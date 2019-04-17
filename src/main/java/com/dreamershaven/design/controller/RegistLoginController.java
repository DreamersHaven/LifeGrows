package com.dreamershaven.design.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dreamershaven.design.contant.DiscContant;
import com.dreamershaven.design.service.UserService;
import com.dreamershaven.design.vo.DesignUserVO;
import com.dreamershaven.wechat.bean.DesignUserDO;
import com.dreamershaven.wechat.util.IMoocJSONResult;
import com.dreamershaven.wechat.util.MD5Utils;
import com.dreamershaven.wechat.util.RedisOperator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "用户注册登录的接口", tags = { "注册和登录的controller" })
public class RegistLoginController extends BasicController {
	// 增加日志
	private static Logger log = LoggerFactory.getLogger(RegistLoginController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private RedisOperator redis;

	@ApiOperation(value = "用户注册", notes = "用户注册接口")
	@PostMapping("/regist")
	public IMoocJSONResult regist(@RequestBody DesignUserDO user) throws Exception {
		// 1、判断用户名和密码必须不为空
		if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
			return IMoocJSONResult.errorMsg("用户名和密码不能为空");
		}
		// 2、判断用户名是否存在
		boolean uernameIsExist = userService.queryUsernameIsExist(user.getUsername());
		if (!uernameIsExist) {
			user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
			//如果用户没有设置头像信息，设置默认的头像信息
			if(user.getPicId()==null||"".equals(user.getPicId())) {
				user.setPicId(DiscContant.NONE_FACE);
			}
			userService.saveUser(user);
		} else {
			return IMoocJSONResult.errorMsg("用户名已经存在，请换一个试试~");
		}

		user.setPassword("");

		DesignUserVO userVO = setUserTokenInfo(user);

		return IMoocJSONResult.ok(userVO);
	}

	/**
	 * 设置userToken信息
	 * 
	 * @param user
	 * @return
	 */
	

	@ApiOperation(value = "用户登录", notes = "用户登录接口")
	@PostMapping("/login")
	public IMoocJSONResult login(@RequestBody DesignUserDO user) throws Exception {
		// 1、判断用户名和密码必须不为空
		if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
			return IMoocJSONResult.errorMsg("用户名和密码不能为空");
		}
		// 2、判断用户名是否存在
		DesignUserDO queryuser = userService.queryUserForLogin(user.getUsername(),
				MD5Utils.getMD5Str(user.getPassword()));
		if (queryuser != null) {// 如果用户存在
			queryuser.setPassword("");
			DesignUserVO userVO = setUserTokenInfo(queryuser);
			return IMoocJSONResult.ok(userVO);
		} else {
			return IMoocJSONResult.errorMsg("用户名或密码不正确，请重试...");
		}

	}

	@ApiOperation(value = "用户注销", notes = "用户注销的接口")
	@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "query")
	@PostMapping("/logout")
	public IMoocJSONResult logout(String userId) throws Exception {
		log.info("用户："+userId+",正在进行注销操作");
		redis.del(USER_REDIS_SESSION + ":" + userId);
		return IMoocJSONResult.ok();
	}
}
