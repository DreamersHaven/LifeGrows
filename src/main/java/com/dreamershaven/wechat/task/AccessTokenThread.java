package com.dreamershaven.wechat.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dreamershaven.wechat.entity.AccessToken;
import com.dreamershaven.wechat.util.WeixinUtil;

/**
 * 定时获取微信access_token的线程
 *在WechatMpDemoApplication中注解@EnableScheduling，在程序启动时就开启定时任务。
 * 每7200秒执行一次
 */
@Component
public class AccessTokenThread {
	
    private static Logger log = LoggerFactory.getLogger(AccessTokenThread.class);

    @Value("${wechat.token.appid}")
	private String appid;
	@Value("${wechat.token.appSecret}")
	private String appSecret;
    // 第三方用户唯一凭证
    public static AccessToken accessToken = null;
    //7200秒执行一次
    @Scheduled(fixedRate=7200000)
    
    public void gettoken(){
    	log.info("###################微信两小时定时任务体########################");
    	log.info("wechatToken info Appid="+appid);
    	log.info("wechatToken info AppSecret="+appSecret);
    	
    	accessToken= WeixinUtil.getAccessToken(appid,appSecret);
        if(null!=accessToken){
            log.info("获取成功，accessToken:"+accessToken.getToken());
        }else {
            log.error("获取token失败");
        }
    }
}


