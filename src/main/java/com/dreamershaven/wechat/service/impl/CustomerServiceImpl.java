package com.dreamershaven.wechat.service.impl;
/**
 * 接入客服系统
 */

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dreamershaven.wechat.entity.resp.CustomerMessage;
import com.dreamershaven.wechat.menu.MenuServiceImpl;
import com.dreamershaven.wechat.service.CustomerService;
import com.dreamershaven.wechat.util.MessageUtil;
import com.dreamershaven.wechat.util.WeixinUtil;

import net.sf.json.JSONObject;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	private static Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);
	// 接入客服系统的接口
	public static String customer_insert_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	/**
	  *接入客服系统
	 *
	 * @param accessToken 有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public int customerInsert(CustomerMessage customerMessage, String accessToken) {
		int result = 0;

		// 拼装接入客服系统的url
		String url = customer_insert_url.replace("ACCESS_TOKEN", accessToken);
		// 将客服对象转换成json字符串
		//String jsonCustomer = JSONObject.fromObject(customerMessage).toString();
		String jsonCustomer=MessageUtil.customerMessageToXml(customerMessage);
		// 调用接口创建菜单
		JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", jsonCustomer);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				log.error("接入客服系统出错 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
				log.error("****" + jsonCustomer + "****");
			}
		}
		return result;
	}

	@Override
	public int customerInsert(String toUserName, String fromUserName, String kfAccount, String accessToken) {
		CustomerMessage custom = new CustomerMessage();
		custom.setToUserName(toUserName);
		custom.setFromUserName(fromUserName);
		custom.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_CUS_SERVICE);
		custom.setCreateTime(new Date().getTime());
//		TransInfo transInfo=new TransInfo();
//		transInfo.setKfAccount(kfAccount);
//		custom.setTransInfo(transInfo);
		return this.customerInsert(custom, accessToken);
	}

	@Override
	public String customerInsert(String toUserName, String fromUserName) {
		CustomerMessage custom = new CustomerMessage();
		custom.setToUserName(toUserName);
		custom.setFromUserName(fromUserName);
		custom.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_CUS_SERVICE);
		String jsonCustomer=MessageUtil.customerMessageToXml(custom);
		return jsonCustomer;
	}

}
