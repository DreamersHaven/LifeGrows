package com.dreamershaven.design.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dreamershaven.design.service.DesignCollectService;
import com.dreamershaven.design.service.DiscTypeService;
import com.dreamershaven.wechat.bean.DesignCollectDO;
import com.dreamershaven.wechat.bean.DesignResultDO;
import com.dreamershaven.wechat.bean.DesignTypeDO;
import com.dreamershaven.wechat.bean.DesignUserDO;
import com.dreamershaven.wechat.controller.CoreController;
import com.dreamershaven.wechat.util.IMoocJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "用户DISC测评报告后台的接口", tags = { "用于获取或者收藏性格类型和详细测评报告controller" })
@RequestMapping("/disc")
public class DiscReportController {
	// 增加日志
	private static Logger log = LoggerFactory.getLogger(CoreController.class);
	@Autowired
	private DiscTypeService discTypeService;
	@Autowired
	private DesignCollectService designCollectService;
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
	
	@ApiOperation(value = "收藏某用户的测试报告", notes = "收藏某用户测试报告的接口")
	@PostMapping("/collectDiscReport")
	public IMoocJSONResult collectDiscReport(@RequestBody DesignCollectDO designCollectDO) throws Exception {
		designCollectService.save(designCollectDO);
		return IMoocJSONResult.ok(designCollectDO);
	}
	
	@ApiOperation(value = "查询某用户收藏的测试报告列表", notes = "查询某用户收藏的测试报告列表的接口")
	@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "query")
	@PostMapping("/querycollectDiscReport")
	public IMoocJSONResult querycollectDiscReport(@RequestParam("userId") String userId) throws Exception {
		//数据校验userId 不能为空
		if (StringUtils.isBlank(userId)) {
			return IMoocJSONResult.errorMsg("用户id不能为空...");
		}
		List<DesignUserDO> designCollectDOs= designCollectService.getUserInfosByCollect(userId);
		return IMoocJSONResult.ok(designCollectDOs);
	}
	
	@ApiOperation(value = "取消对某个用户的关注", notes = "取消对某个用户的关注的接口")
	@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "query")
	@PostMapping("/delcollectDiscReport")
	public IMoocJSONResult delcollectDiscReport(@RequestParam("userId") String userId) throws Exception {
		//数据校验userId 不能为空
		if (StringUtils.isBlank(userId)) {
			return IMoocJSONResult.errorMsg("用户id不能为空...");
		}
		int result= designCollectService.remove(userId);
		return IMoocJSONResult.ok("取消关注操作成功");
	}
	
	
	
	
	
	
	
}
