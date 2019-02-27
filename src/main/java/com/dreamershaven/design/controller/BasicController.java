package com.dreamershaven.design.controller;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dreamershaven.design.vo.DesignUserVO;
import com.dreamershaven.wechat.bean.DesignUserDO;
import com.dreamershaven.wechat.util.RedisOperator;



@RestController
public class BasicController {
	
	@Autowired
	public RedisOperator redis;
	
	public static final String USER_REDIS_SESSION = "user-redis-session";
	
	// 文件保存的命名空间
	public static final String FILE_SPACE = "C:/imooc_videos_dev";
	
	// ffmpeg所在目录
	public static final String FFMPEG_EXE = "C:\\ffmpeg\\bin\\ffmpeg.exe";
	
	// 每页分页的记录数
	public static final Integer PAGE_SIZE = 5;
	
	public DesignUserVO setUserTokenInfo(DesignUserDO user) {
		String uuiqueToken = UUID.randomUUID().toString();
		redis.set(USER_REDIS_SESSION + ":" + user.getUserId(), uuiqueToken, 1000 * 60 * 30);
		DesignUserVO userVO = new DesignUserVO();
		BeanUtils.copyProperties(user, userVO);
		userVO.setUserToken(uuiqueToken);
		return userVO;
	}
	
}
