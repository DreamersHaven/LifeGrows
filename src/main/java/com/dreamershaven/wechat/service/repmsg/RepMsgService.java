package com.dreamershaven.wechat.service.repmsg;

import java.util.Map;

/**
 * 回复用户消息的接口
 * @author Administrator
 *
 */
public interface RepMsgService {
	public String repMessage(Map<String, String> requestMap);
}
