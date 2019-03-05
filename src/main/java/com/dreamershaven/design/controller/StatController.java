package com.dreamershaven.design.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamershaven.design.service.StatService;
import com.dreamershaven.design.vo.DiscStatVO;
import com.dreamershaven.wechat.controller.CoreController;
import com.dreamershaven.wechat.util.IMoocJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "DISC测评统计接口", tags = { "用于统计DISC相关信息的controller" })
public class StatController {
	// 增加日志
	private static Logger log = LoggerFactory.getLogger(CoreController.class);
	@Autowired
	private StatService statService;
	/**
	 * 保存用户的DISC测试结果
	 * 1、查询该用户已经保存了几条DISC测试记录
	 * 2、如果超过或者等于三条，删除日期最久的一条记录
	 * 3、保存最新的DISC测试记录
	 * @param discResult
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "获得用户总数测试总数等统计信息", notes = "管理员可以查看DISC的相关统计信息")
	@PostMapping("/statDisc")
	public IMoocJSONResult queryDiscType(String userId) throws Exception {
		log.info("用户："+userId+",正在获取DISC统计信息:");
		DiscStatVO discStatVO=statService.stat();
		return IMoocJSONResult.ok(discStatVO);
	}
	
}
