package com.dreamershaven.design.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dreamershaven.design.service.DiscService;
import com.dreamershaven.wechat.bean.DesignResultDO;
import com.dreamershaven.wechat.controller.CoreController;
import com.dreamershaven.wechat.util.IMoocJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "用户DISC后台的接口", tags = { "保存DISC测试结果和查询DISC测试结果的controller" })
public class DiscController {
	// 增加日志
	private static Logger log = LoggerFactory.getLogger(CoreController.class);
	@Autowired
	private DiscService discService;
	/**
	 * 保存用户的DISC测试结果
	 * 1、查询该用户已经保存了几条DISC测试记录
	 * 2、如果超过或者等于三条，删除日期最久的一条记录
	 * 3、保存最新的DISC测试记录
	 * @param discResult
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "保存DISC测试结果", notes = "保存DISC测试结果接口")
	@PostMapping("/saveDiscResult")
	public IMoocJSONResult saveDiscResult(@RequestBody DesignResultDO discResult) throws Exception {
		
		log.info("用户："+discResult.getUserId()+",正在保存DISC测试结果:");
		log.info("最符合的DISC："+discResult.getMresult()+"。");
		
		Date date = new Date();
		Timestamp timeStamep = new Timestamp(date.getTime());
		discResult.setGmtCreate(timeStamep);
		discService.saveResult(discResult);
		return IMoocJSONResult.ok(discResult);
	}
}
