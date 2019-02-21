package com.dreamershaven.design.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamershaven.design.service.DiscTypeService;
import com.dreamershaven.wechat.bean.DesignResultDO;
import com.dreamershaven.wechat.bean.DesignTypeDO;
import com.dreamershaven.wechat.controller.CoreController;
import com.dreamershaven.wechat.util.IMoocJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "用户DISC测评报告后台的接口", tags = { "用于获取性格类型和详细测评报告controller" })
@RequestMapping("/disc")
public class DiscReportController {
	// 增加日志
	private static Logger log = LoggerFactory.getLogger(CoreController.class);
	@Autowired
	private DiscTypeService discTypeService;
	/**
	 * 保存用户的DISC测试结果
	 * 1、查询该用户已经保存了几条DISC测试记录
	 * 2、如果超过或者等于三条，删除日期最久的一条记录
	 * 3、保存最新的DISC测试记录
	 * @param discResult
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "获得性格特质类型", notes = "依据测评结果获得性格特质类型的接口")
	@PostMapping("/querydisctype")
	public IMoocJSONResult queryDiscType(@RequestBody DesignResultDO discResult) throws Exception {
		
		log.info("用户："+discResult.getUserId()+",正在获取DISC性格特质类型:");
		DesignTypeDO designTypeDO=discTypeService.queryUserDISCInfo(discResult.getYvalue(), discResult.getMresult(), "M");
		return IMoocJSONResult.ok(designTypeDO);
	}
	
}
