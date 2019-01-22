package com.dreamershaven.wechat.service.admin;

/**
 * 微信公众号管理功能接口
 * @author Administrator
 *
 */
public interface IWXManagement {
	/**
	 * 依据传递的参数信息，执行相关管理功能
	 * 返回JSON字符串格式，以文字或者图文方式将执行结果返回给微信公众平台
	 * @param requestMap
	 * @return
	 */
	public String operation(String[] requestMap);
}
