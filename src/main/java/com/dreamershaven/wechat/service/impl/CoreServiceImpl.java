package com.dreamershaven.wechat.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.wechat.contant.WeChatContant;
import com.dreamershaven.wechat.entity.resp.Article;
import com.dreamershaven.wechat.entity.resp.NewsMessage;
import com.dreamershaven.wechat.entity.resp.TextMessage;
import com.dreamershaven.wechat.service.CoreService;
import com.dreamershaven.wechat.service.CustomerService;
import com.dreamershaven.wechat.util.MessageUtil;



/**
 * 核心服务类
 */
@Service("coreService")
public class CoreServiceImpl implements CoreService {

	private static Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);
	
	//创建接入客服系统的服务对象
	@Autowired
	private CustomerService customerService;
	
	
	 
	/**
	 * 处理微信发来的请求（动态获取数据库中的回复信息）
	 * 1、判断用户发送的消息类型
	 * 2、依据用户发送的消息类型，采用工厂模式构建不同的回复消息对象，生成不同的回复消息
	 * @param request
	 * @return
	 */
	public String processRequestByDB(HttpServletRequest request) {
		return "";
		
	}

	/**
	 * 处理微信发来的请求（包括事件的推送）
	 *
	 * @param request
	 * @return
	 */
	public String processRequest(HttpServletRequest request) {

		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			log.info("###############收到来自:[" + fromUserName+"],的信息#######################");
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
			// 自动回复文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {

				// 如果用户发送表情，则回复同样表情。
				if (isQqFace(content)) {
					respContent = content;
					textMessage.setContent(respContent);
					// 将文本消息对象转换成xml字符串
					respMessage = MessageUtil.textMessageToXml(textMessage);
					
				} else {
					// 回复固定消息
					switch (content) {

					
					case "活动": {
						// 近期线下活动
						Article article = new Article();
						article.setTitle("梦享邦近期活动预告");
						// 图文消息中可以使用QQ表情、符号表情
						article.setDescription("近期活动一网打尽，总有一款适合你....\n\n点击图文，查看详细信息..");
						// 将图片置为空
						article.setPicUrl(WeChatContant.ACT_TOP_PIC);
						article.setUrl(WeChatContant.ACT_RECENT_URL);
						articleList.add(article);
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respMessage = MessageUtil.newsMessageToXml(newsMessage);
						break;
					}
					case "空间": {
						//如果连接数据库，则从数据库中动态取出空间信息并显示，如果未连接数据库，则采用静态方式显示空间信息
						StringBuffer buffer = new StringBuffer();
						
							buffer.append("DreamersHaven 学生空间一表").append("\n\n");
							buffer.append("1: 传媒空间-临近传媒大学、第二外国语学院、物资学院").append("\n");
							buffer.append("地址：东领鉴筑1号楼4单元303").append("\n");
							buffer.append(WeChatContant.CHUANGM_MIP_PIC).append("\n");
							buffer.append("空间管理员：15600574877").append("\n\n");
							buffer.append("2： 良乡空间-临近北理工、北中医、北工商、首师范等...").append("\n");
							buffer.append("地址：良乡大学城旭辉天地12号院3号楼（良乡大学城地铁口向西300米）。").append("\n");
							buffer.append(WeChatContant.LIANGXIANG_MAP_PIC).append("\n");
							buffer.append("空间管理员：13176806293").append("\n\n");
												
						respContent = String.valueOf(buffer);
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
						break;
					}

					case "课程": {
						// 测试网址回复
						respContent = "<a href=\"http://www.baidu.com\">栏目建设中,敬请期待...</a>";
						textMessage.setContent(respContent);
						// 将文本消息对象转换成xml字符串
						respMessage = MessageUtil.textMessageToXml(textMessage);
						break;
					}

					case "客服": {
						//转接人工客服系统
						//String accessToken = AccessTokenThread.accessToken.getToken();
						respMessage=customerService.customerInsert(fromUserName,toUserName);
						break;
					}

					default: {
						StringBuffer buffer = new StringBuffer();
						buffer.append("您好，我是梦享邦小客服，很高兴为您服务。有问题请回复括号内关键字").append("\n\n");
						buffer.append("[活动]- 近期线下活动").append("\n");
						buffer.append("[空间]- 附近学生空间").append("\n");
						buffer.append("[课程]-线上课程").append("\n");
						buffer.append("[转载]-转载说明").append("\n");
						buffer.append("[客服]-转接人工服务").append("\n");

						buffer.append("也可以通过微信直接联系我们").append("\n\n");
						buffer.append("zhn_429 (微信)").append("\n");
						respContent = String.valueOf(buffer);
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
						break;
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
					//联系我们
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
		} catch (Exception e) {
			e.printStackTrace();
		}

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
