package com.dreamershaven.design.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dreamershaven.design.service.UserConstantInterface;
import com.dreamershaven.design.service.UserService;
import com.dreamershaven.design.vo.DesignUserVO;
import com.dreamershaven.design.vo.WxUserVO;
import com.dreamershaven.wechat.bean.DesignUserDO;
import com.dreamershaven.wechat.util.HttpUtils;
import com.dreamershaven.wechat.util.IMoocJSONResult;
import com.dreamershaven.wechat.util.RedisOperator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

/**
 * 微信授权登录
 * @author dongyaxin
 *
 */

@RestController
@Api(value = "微信授权登录的接口", tags = { "微信授权登录的controller" })
public class WxLoginController extends BasicController {
		// 增加日志
		private static Logger log = LoggerFactory.getLogger(WxLoginController.class);
		@Autowired
		private UserService userService;
		@Autowired
		private RedisOperator redis;
	   
		@ApiOperation(value = "用户注册", notes = "用户注册接口")
		@PostMapping("/wxlogin")
		public IMoocJSONResult login(@RequestBody WxUserVO user) throws Exception {
			log.info("用户授权登录中..code:"+user.getCode()); 
			JSONObject jsonObject = null;
			
			 // 配置请求参数
	        Map<String, String> param = new HashMap<>();
	        param.put("appid", UserConstantInterface.WX_LOGIN_APPID);
	        param.put("secret", UserConstantInterface.WX_LOGIN_SECRET);
	        param.put("js_code", user.getCode());
	        param.put("grant_type", UserConstantInterface.WX_LOGIN_GRANT_TYPE);
	        
	        // 发送请求
	        String wxResult = HttpUtils.sendGet(UserConstantInterface.WX_LOGIN_URL, param);
	        log.info("从微信服务器获取的用户信息:"+wxResult); 
	        
	        jsonObject=JSONObject.fromObject(wxResult);
	        
	        // 获取参数返回的
	        String session_key = jsonObject.get("session_key").toString();
	        String open_id = jsonObject.get("openid").toString();
	        log.info("用户授权登录中..session_key:"+session_key+";openid:"+open_id);
	        //根据返回的user实体类，判断用户是否是新用户，不是的话，更新最新登录时间，是的话，将用户信息存到数据库
	        DesignUserVO userVO = null;
	        DesignUserDO userinfo=null;
	        userinfo=userService.queryUserWxIsExist(open_id);
	        if(userinfo!=null) {
	        	
	        }else {
	        	userinfo=new DesignUserDO();
	        	userinfo.setWxId(open_id);
	        	userinfo.setUsername(user.getNickName());
	        	userinfo.setUserId(user.getNickName());
	        	userinfo.setPicId(user.getAvatarUrl());
	        	userService.saveUser(userinfo);
	        }
	        
	        userVO = setUserTokenInfo(userinfo);
			return IMoocJSONResult.ok(userVO);
		}

}
