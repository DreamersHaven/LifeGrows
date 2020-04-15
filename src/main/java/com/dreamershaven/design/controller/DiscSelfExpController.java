package com.dreamershaven.design.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamershaven.design.service.DesignIncliedService;
import com.dreamershaven.design.service.DesignIncliedUserService;
import com.dreamershaven.wechat.bean.DesignIncliedDO;
import com.dreamershaven.wechat.bean.DesignIncliedUserDO;
import com.dreamershaven.wechat.util.IMoocJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "DISC行为倾向自评", tags = { "DISC行为倾向自评的controller" })
@RequestMapping("/selfExp")
public class DiscSelfExpController extends BasicController {

	@Autowired
	private DesignIncliedService designIncliedService;
	@Autowired
	private DesignIncliedUserService designIncliedUserService;

	@ApiOperation(value = "查询DISC行为倾向完整信息表", notes = "查询DISC行为倾向完整信息表")
	@ApiImplicitParam(name = "discType", value = "DISC", required = true, dataType = "String", paramType = "query")
	@PostMapping("/queryAllInfoByDiscType")
	public IMoocJSONResult query(String discType) throws Exception {
		//依据DISC测评结果，查询相应的行为倾向完整信息
		//客户端传递来的disc测评结果为大写的DISC的任意组合，要转换成 sql 语句 in 的查询格式，例如：DS 转换成 'D','S'
		
		discType=this.converStrToSqlIn(discType);
		List<DesignIncliedDO> designIncliedDOList = designIncliedService.queryByDISC(discType);
		return IMoocJSONResult.ok(designIncliedDOList);

	}
	
	
	@ApiOperation(value = "重置某个用户的行为倾向信息", notes = "重置某个用户的行为倾向信息")
	@ApiImplicitParam(name = "userId", value = "14", required = true, dataType = "String", paramType = "query")
	@PostMapping("/reset")
	public IMoocJSONResult reset(String userId) throws Exception {
		//重置行为倾向信息，用户点击重置按钮之后，删除用户自评行为信息，显示完整的行为倾向列表
		int result=designIncliedUserService.remove(Long.parseLong(userId));
		return IMoocJSONResult.ok("重置成功！");

	}
	
	
	@ApiOperation(value = "保存某个用户的行为倾向自评结果", notes = "保存某个用户的行为倾向自评结果")
	@PostMapping("/save")
	public IMoocJSONResult save(@RequestBody List<DesignIncliedUserDO> designIncliedUserDOs) throws Exception {
		//依据用户评级分组保存用户的行为倾向自评结果。例如：D工作性格中的评分为5级的行为优势：目标导向|纵观全局|良好的组织能力|寻求切实可行的解决方案
		//作为一条记录保存
		int result=designIncliedUserService.batchSave(designIncliedUserDOs);
		return IMoocJSONResult.ok("用户自评结果保存成功！");

	}
	
	private String converStrToSqlIn(String str) {
		StringBuffer suf=new StringBuffer();
		char ss[] = str.toCharArray();//利用toCharArray方法转换
		for (int i = 0; i < ss.length; i++) {
			suf.append("'");
			suf.append(ss[i]);
			suf.append("'");
			if(i!=ss.length-1) {
			suf.append(",");
			}		
		}
		return suf.toString();
		
	}

	

}
