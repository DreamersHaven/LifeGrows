package com.dreamershaven.wechat.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="wechat.token")
public  class GlobalWechat {
	
	public static final String  APPID="wx9360be572e5175ac";
	public static final String  APPSECRET="1839f2e1ed3f970f9e7683c15de67b7d";
	
	 
}
