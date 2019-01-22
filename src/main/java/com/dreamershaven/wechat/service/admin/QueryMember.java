package com.dreamershaven.wechat.service.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.wechat.bean.StudentsDO;
import com.dreamershaven.wechat.mapper.StudentsMapper;
@Service("queryMember")

public class QueryMember implements IWXManagement {
	//创建会员管理的数据库对象
	private static Logger log = LoggerFactory.getLogger(QueryMember.class);
	@Autowired
	private StudentsMapper studentsMapper;
	@Override
	public String operation(String[] requestMap) {
		StringBuffer buffer = new StringBuffer();
		List<StudentsDO> studentsDOs = studentsMapper.list(null);
		buffer.append("会员一览表").append("\n\n");
		for (StudentsDO studentsDO : studentsDOs) {
			log.info("会员名称："+studentsDO.getName());
			buffer.append("会员姓名["+studentsDO.getName()+"]");
			buffer.append("["+studentsDO.getVipcardno()+"]");
			buffer.append("["+studentsDO.getPhone()+"]");
			buffer.append("["+studentsDO.getSchool()+"]");
			buffer.append("\n");	
		}
		
		return buffer.toString();
		 
	}

}
