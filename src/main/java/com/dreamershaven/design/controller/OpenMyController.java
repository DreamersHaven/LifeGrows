package com.dreamershaven.design.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamershaven.openmy.service.OpenmyAnswerService;
import com.dreamershaven.openmy.service.OpenmyDefqueService;
import com.dreamershaven.wechat.bean.OpenmyAnswerDO;
import com.dreamershaven.wechat.bean.OpenmyDefqueDO;
import com.dreamershaven.wechat.controller.CoreController;
import com.dreamershaven.wechat.util.IMoocJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "公开的我之别人眼中的自己的后台接口", tags = { "用于收集显示别人对自己的反馈的controller" })
@RequestMapping("/openMy")
public class OpenMyController extends BasicController {
	
	private static Logger log = LoggerFactory.getLogger(CoreController.class);

	@Autowired
	private OpenmyDefqueService openmyDefqueService;
	
	@Autowired
	private OpenmyAnswerService openmyAnswerService;

	@ApiOperation(value = "获得默认的问题信息列表", notes = "获得默认的问题信息列表")
	@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "query")
	@PostMapping("/queryDefques")
	public IMoocJSONResult queryDefques(String userId) throws Exception {
		// 如果userId为"def"查询默认的四个问题，否则按照userId查找该用户是否自己设置的问题列表，
		// 如果没有查询到用户自己定义的问题列表，依旧显示默认问题列表
		List<OpenmyDefqueDO> openmyDefqueDOList=null;
		if(userId.equals("def")) {
			openmyDefqueDOList= openmyDefqueService.list(null);
		}
		 
		return IMoocJSONResult.ok(openmyDefqueDOList);

	}
	
	
	@ApiOperation(value = "保存收集的反馈答案", notes = "保存收集的反馈答案")
	@PostMapping("/saveDiscResult")
	public IMoocJSONResult saveDiscResult(@RequestBody OpenmyAnswerDO openmyAnswerDO) throws Exception {
		//前台以#为问题答案和问题序号的分隔符号
		log.info("用户："+openmyAnswerDO.getUserId()+",正在保存收到给该用户的反馈结果:");
		
		if(openmyAnswerDO.getQuestions()==null||"".equals(openmyAnswerDO.getQuestions())) {
			return IMoocJSONResult.errorMsg("没有收到反馈的问题序号信息，请检查输入");
		}
		
		if(openmyAnswerDO.getAnswer()==null||"".equals(openmyAnswerDO.getAnswer())) {
			return IMoocJSONResult.errorMsg("没有收到反馈的答案信息，请检查输入");
		}
		
		String[] questionID=openmyAnswerDO.getQuestions().split("#");
		String[] answers=openmyAnswerDO.getAnswer().split("#");
		
		Date date = new Date();
		Timestamp timeStamep = new Timestamp(date.getTime());
		Map<String, Object> query = new HashMap<>(16);
		query.put("userId", openmyAnswerDO.getUserId());
		int maxGroupId=openmyAnswerService.maxGroupId(query);
		log.info("目前改用戶收到反馈的最大分组序号："+maxGroupId);
		
		 for (int i = 0; i < questionID.length; i++) {
			 log.info("问题序号："+questionID[i]);
			 log.info("反馈答案："+answers[i]);
			 OpenmyAnswerDO newOpenmyAnswerDO=new OpenmyAnswerDO();
			 newOpenmyAnswerDO.setQuestionsId(new Integer(questionID[i]));
			 newOpenmyAnswerDO.setUserId(openmyAnswerDO.getUserId());
			 newOpenmyAnswerDO.setAnswer(answers[i]);
			 newOpenmyAnswerDO.setFeedbackTime(timeStamep);
			 newOpenmyAnswerDO.setGroupId(new Integer(maxGroupId+1));
			 openmyAnswerService.save(newOpenmyAnswerDO);
         }
		
		return IMoocJSONResult.ok("反馈提交成功！感谢老铁~~");
	}
	
	@ApiOperation(value = "显示收集的反馈信息列表", notes = "显示收集的反馈信息列表")
	@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "query")
	@PostMapping("/queryOpenMyInfo")
	public IMoocJSONResult queryOpenMyInfo(String userId) throws Exception {

		List<OpenmyAnswerDO> openmyAnswerDOList=null;
		Map<String, Object> query = new HashMap<>(16);
		query.put("userId", userId);
		openmyAnswerDOList=openmyAnswerService.list(query);
		return IMoocJSONResult.ok(openmyAnswerDOList);

	}
	

}
