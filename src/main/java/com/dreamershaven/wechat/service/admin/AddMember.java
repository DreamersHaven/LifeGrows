package com.dreamershaven.wechat.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.wechat.bean.StudentsDO;
import com.dreamershaven.wechat.mapper.StudentsMapper;
/**
 * 通过微信公众号添加会员信息
 * @author Administrator
 *
 */

@Service("addMember")

public class AddMember implements IWXManagement {
	@Autowired
	private StudentsMapper studentsMapper;
	@Override
	public String operation(String[] requestMap) {
		//字符串数组的顺序[会员卡号][会员姓名][手机号码][所在学校]
		StudentsDO student=new StudentsDO();
		student.setVipcardno(requestMap[2]);
		student.setName(requestMap[3]);
		student.setPhone(requestMap[4]);
		student.setSchool(requestMap[5]);
		if(studentsMapper.save(student)>0){
			return "新会员添加成功";
		}
		return "新会员添加失败，请查询日志信息，排查错误";
		
	}

}
