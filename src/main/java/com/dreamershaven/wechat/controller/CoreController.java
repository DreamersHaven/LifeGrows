package com.dreamershaven.wechat.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dreamershaven.wechat.service.CoreService;
import com.dreamershaven.wechat.service.repmsg.RepMsgService;
import com.dreamershaven.wechat.util.MessageUtil;
import com.dreamershaven.wechat.util.SignUtil;

@RestController
@RequestMapping("")
public class CoreController {
	// 增加日志
	private static Logger log = LoggerFactory.getLogger(CoreController.class);
	@Autowired
	private CoreService coreService;
	@Autowired
	private RepMsgService repMsgService;
	
	@Value("${isDataBase}")
	private String isDataBase;
	// 验证是否来自微信服务器的消息
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String checkSignature(@RequestParam(name = "signature", required = false) String signature,
			@RequestParam(name = "nonce", required = false) String nonce,
			@RequestParam(name = "timestamp", required = false) String timestamp,
			@RequestParam(name = "echostr", required = false) String echostr) {
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			log.info("接入成功");
			return echostr;
		}
		log.error("接入失败");
		return "";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void DoPost(HttpServletRequest request, HttpServletResponse response) {
		log.info("响应用户发送信息...");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		String message = null;
		try {
			if(isDataBase!=null&&"true".equals(isDataBase)) {
				Map<String, String> requestMap = MessageUtil.parseXml(request);
				message = repMsgService.repMessage(requestMap);
			}else {
				message = coreService.processRequest(request);
			}
			
			if (message != null) {
				out = response.getWriter();
				out.write(message);
				out.close();
			}
			
		} catch (Exception e) {
			out.close();
			e.printStackTrace();
		}
	}
}
