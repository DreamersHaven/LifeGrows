package com.dreamershaven.design.service;

public interface UserConstantInterface {
	// 请求的网址
    public static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";

	// 固定参数
    public static final String WX_LOGIN_GRANT_TYPE = "authorization_code";
    
    // 你的appid
    public static final String WX_LOGIN_APPID = "wx34fb3ff2e6437831";
	// 你的密匙
    public static final String WX_LOGIN_SECRET = "825eb523b6003b93a938ba87c7b1c524";
    

}
