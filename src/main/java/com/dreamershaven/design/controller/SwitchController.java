package com.dreamershaven.design.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamershaven.design.service.SwitchService;
import com.dreamershaven.wechat.bean.SwitchDO;
import com.dreamershaven.wechat.util.IMoocJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "管理员用户系统设置项的接口", tags = { "管理员用户系统开关设置的controller" })
@RequestMapping("/admin")
public class SwitchController extends BasicController {

	@Autowired
	private SwitchService switchService;

	@ApiOperation(value = "查询所有系统开关信息", notes = "查询所有系统开关信息")
	@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "query")
	@PostMapping("/queryswitchs")
	public IMoocJSONResult query(String userId) throws Exception {
		// 判断是否为管理员用户，如果不是管理员用户，提示没有权限获取该接口的数据（有时间的时候再实现）

		List<SwitchDO> switchList = switchService.list(null);
		return IMoocJSONResult.ok(switchList);

	}

	@ApiOperation(value = "修改开关设置信息", notes = "修改开关设置信息")
	@PostMapping("/updateswitchs")
	public IMoocJSONResult updateswitchs(@RequestBody SwitchDO switchDO) throws Exception {
		int result = switchService.updateOpenState(switchDO);
		if (result != 0) {
			return IMoocJSONResult.ok("操作成功~");
		} else {
			return IMoocJSONResult.errorMsg("操作失败，请稍后再试");
		}

	}

	@ApiOperation(value = "获取某个系统开关状态", notes = "获取某个系统开关状态")
	@PostMapping("/queryOneswitch")
	public IMoocJSONResult queryOneswitch(@RequestBody SwitchDO switchDO) throws Exception {
		Boolean result = switchService.isopen(switchDO.getKeyvalue());

		return IMoocJSONResult.ok(result);

	}

}
