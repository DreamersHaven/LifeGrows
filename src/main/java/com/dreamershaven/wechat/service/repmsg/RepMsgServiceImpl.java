package com.dreamershaven.wechat.service.repmsg;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dreamershaven.wechat.bean.RespMsgDO;
import com.dreamershaven.wechat.contant.WeChatContant;
import com.dreamershaven.wechat.entity.resp.Article;
import com.dreamershaven.wechat.entity.resp.NewsMessage;
import com.dreamershaven.wechat.entity.resp.TextMessage;
import com.dreamershaven.wechat.mapper.RespMsgMapper;
import com.dreamershaven.wechat.service.CustomerService;
import com.dreamershaven.wechat.service.SpaceService;
import com.dreamershaven.wechat.service.admin.IWXManagement;
import com.dreamershaven.wechat.service.impl.CoreServiceImpl;
import com.dreamershaven.wechat.util.MessageUtil;
import com.dreamershaven.wechat.util.SpringUtil;

@Service("repMsgService")
public class RepMsgServiceImpl implements RepMsgService {
	private static Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);

	@Value("${wechat.admin.openID}")
	private String adminOpenID;

	@Value("${wechat.admin.password}")
	private String adminPassword;

	// 创建空间管理的服务对象，空间信息存储在数据库中
	@Autowired
	private SpaceService spaceService;

	// 创建接入客服系统的服务对象
	@Autowired
	private CustomerService customerService;

	// 创建消息回复的数据库对象
	@Autowired
	private RespMsgMapper respMsgDao;

	// 创建管理员操作的对象
	
	private IWXManagement iWXManagement;

	/**
	 * 
	 * 依据用户发送的消息类型，查找数据库设置信息，返回相应图文信息 接受到用户发送的消息为文本类型,通过用户输入的信息，匹配关键字，并返回相应的信息
	 * 特殊关键字处理：“客服”、“空间”、“default”
	 * “管理”-当接收到该信息时，判断发消息的用户是否为公众号管理员用户，如果是给予管理提示菜单；如果不是则返回普通用户默认提示信息。
	 * 目前主要实现如下管理功能： 1、管理密码+1：查询所有会员信息，按照姓名的字母排序，生成一张图片，返回给公众号。
	 * 2、管理密码+2：添加会员信息，格式如下：会员卡号+会员姓名+手机号码+所在学校
	 */
	@Override
	public String repMessage(Map<String, String> requestMap) {
		// 构造返回消息的基本信息
		String respMessage = null;
		// 默认返回的文本消息内容
		String respContent = "请求处理异常，请稍候尝试！";
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		log.info("###############收到来自:[" + fromUserName + "],的信息#######################");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");

		// 回复文本消息
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);

		// 创建图文消息
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);

		List<Article> articleList = new ArrayList<Article>();

		// 点击菜单id
		String EventKey = requestMap.get("EventKey");
		// 接收文本消息内容
		String content = requestMap.get("Content");

		Map<String, Object> query = new HashMap<>(16);

		// 1、如果用户发送消息为文本类型，先处理特殊情况“空间”、“客服”等
		// 然后，通过关键字信息查找是否有匹配的回复信息，依据数据库中的设置，动态生成回复信息
		// 优化：由于此部分数据的更改并不频繁，读取此部分数据需加入缓存机制
		// 如果没有匹配到相应的关键字，生成默认回复信息
		if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
			// 如果用户发送表情，则回复同样表情。
			if (isQqFace(content)) {
				respContent = content;
				textMessage.setContent(respContent);
				// 将文本消息对象转换成xml字符串
				respMessage = MessageUtil.textMessageToXml(textMessage);

			} else {
				// 处理特殊情况
				switch (content) {
				case "空间": {
					StringBuffer buffer = new StringBuffer();
					buffer = spaceService.buildWechatInfo();
					respContent = String.valueOf(buffer);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
					return respMessage;

				}
				case "客服": {
					// 转接人工客服系统
					// String accessToken = AccessTokenThread.accessToken.getToken();
					respMessage = customerService.customerInsert(fromUserName, toUserName);
					return respMessage;
				}

				case "管理": {
					if (fromUserName.equals(adminOpenID)) {
						content = "管理";
					} else {
						content = "default";
					}
				}

				}
				// 判断是否为管理类消息：1、判断是否为微信管理员发送的消息。2、以加号为分割符号，将消息分割成字符串数组，判断第一个数组的内容是否和管理员密码一致。
				// 微信管理类功能采用动态创建bean的方式实现，便于管理类功能的扩展
				if (fromUserName.equals(adminOpenID)) {
					String[] strs = content.split(":", 6);
					if (strs[0].equals(adminPassword)) {
						log.info("#############管理员密码验证通过###############");
						iWXManagement=(IWXManagement) SpringUtil.getBean(strs[1]);
						respContent = iWXManagement.operation(strs);
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);

						
						return respMessage;
					}
				}

				// 通过关键字信息查找是否有匹配的回复信息，依据数据库中的设置，动态生成回复信息

				query.put("keyWord", content);
				List<RespMsgDO> respMsgDOs = respMsgDao.list(query);
				if (respMsgDOs == null || respMsgDOs.size() == 0) {
					query.put("keyWord", "default");
					respMsgDOs = respMsgDao.list(query);
				}

				for (RespMsgDO respMsgDO : respMsgDOs) {
					// 构造回复信息，依据回复的信息类型，构造回复信息
					if ("Article".equals(respMsgDO.getReqMsgType())) {
						// 近期线下活动
						Article article = new Article();
						article.setTitle(respMsgDO.getTitle());
						article.setDescription(respMsgDO.getDescription());
						article.setPicUrl(respMsgDO.getPicUrl());
						article.setUrl(respMsgDO.getUrl());
						articleList.add(article);
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
					} else if ("TextMessage".equals(respMsgDO.getReqMsgType())) {
						textMessage.setContent(respMsgDO.getContent());
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}

				}

			}
		}

		// 图片消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
			// 测试单图文回复
			Article article = new Article();
			article.setTitle("您的截图信息已收到，\n感谢对梦享邦活动的支持！");
			// 图文消息中可以使用QQ表情、符号表情
			article.setDescription(WeChatContant.ACT_REG_DESC);
			// 将图片置为空
			article.setPicUrl(WeChatContant.ACT_TOP_PIC);
			article.setUrl(WeChatContant.ACT_REG_URL);
			articleList.add(article);
			newsMessage.setArticleCount(articleList.size());
			newsMessage.setArticles(articleList);
			respMessage = MessageUtil.newsMessageToXml(newsMessage);
		}
		// 地理位置消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
			respContent = "您发送的是地理位置消息！";
			textMessage.setContent(respContent);
			// 将文本消息对象转换成xml字符串
			respMessage = MessageUtil.textMessageToXml(textMessage);
		}
		// 链接消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
			respContent = "";
			textMessage.setContent(respContent);
			// 将文本消息对象转换成xml字符串
			respMessage = MessageUtil.textMessageToXml(textMessage);

		}
		// 音频消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
			respContent = "您发送的是音频消息！";
			textMessage.setContent(respContent);
			// 将文本消息对象转换成xml字符串
			respMessage = MessageUtil.textMessageToXml(textMessage);
		}

		// 事件推送
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
			// 事件类型
			String eventType = requestMap.get("Event");
			// 自定义菜单点击事件
			if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
				switch (EventKey) {
				// 联系我们
				case "32": {
					respContent = WeChatContant.CUS_SER;
					break;
				}
				case "12": {
					respContent = "这是第一栏第一个";
					break;
				}
				case "21": {
					respContent = "这是第二栏第一个";
					break;
				}

				default: {
					log.error("开发者反馈：EventKey值没找到，它是:" + EventKey);
					respContent = "很抱歉，此按键功能正在升级无法使用";
				}
				}
				textMessage.setContent(respContent);
				// 将文本消息对象转换成xml字符串
				respMessage = MessageUtil.textMessageToXml(textMessage);
			} else if (eventType.equals(MessageUtil.EVENT_TYPE_VIEW)) {
				// 对于点击菜单转网页暂时不做推送
			}

			// 订阅
			else if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
				// 测试单图文回复
				Article article = new Article();
				article.setTitle("终于等到你！Dear Dreamer!");
				// 图文消息中可以使用QQ表情、符号表情
				article.setDescription(WeChatContant.NEW_USER_DESC);
				// 将图片置为空
				article.setPicUrl(WeChatContant.LOGO_PIC_URL);
				article.setUrl(WeChatContant.ABOUT_ME_URL);
				articleList.add(article);
				newsMessage.setArticleCount(articleList.size());
				newsMessage.setArticles(articleList);
				respMessage = MessageUtil.newsMessageToXml(newsMessage);
			} else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
				// 测试单图文回复
				Article article = new Article();
				article.setTitle("这是已关注用户扫描二维码弹到的界面");
				// 图文消息中可以使用QQ表情、符号表情
				article.setDescription("点击图文可以跳转到百度首页");
				// 将图片置为空
				article.setPicUrl("http://www.sinaimg.cn/dy/slidenews/31_img/2016_38/28380_733695_698372.jpg");
				article.setUrl("http://www.baidu.com");
				articleList.add(article);
				newsMessage.setArticleCount(articleList.size());
				newsMessage.setArticles(articleList);
				respMessage = MessageUtil.newsMessageToXml(newsMessage);
			}
			// 取消订阅
			else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
				// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
			}

		}

		// 2、响应事件

		// 3、响应其他类型的用户消息（图片、位置信息、链接、音频、视频等）
		// 依据消息类型查找数据库中相关设置，生成回复信息
		// 如果未找到设置信息，返回默认提示信息

		return respMessage;
	}

	/**
	 * 判断是否是QQ表情
	 *
	 * @param content
	 * @return
	 */
	public static boolean isQqFace(String content) {
		boolean result = false;

		// 判断QQ表情的正则表达式
		String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
		Pattern p = Pattern.compile(qqfaceRegex);
		Matcher m = p.matcher(content);
		if (m.matches()) {
			result = true;
		}
		return result;
	}

}
