package com.dreamershaven.wechat.bean;

import java.io.Serializable;



/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-10-20 16:25:48
 */
public class StudentsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//学生标识
	private Integer id;
	//会员卡号
	private String vipcardno;
	//姓名
	private String name;
	//
	private String phone;
	//性别
	private String sex;
	//学校
	private String school;
	//第几届
	private String session;
	//专业
	private String specialty;
	//关系分类
	private String relationship;
	//会员卡状态
	private String vipcardstate;
	//备注
	private String remarks;

	/**
	 * 设置：学生标识
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：学生标识
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：会员卡号
	 */
	public void setVipcardno(String vipcardno) {
		this.vipcardno = vipcardno;
	}
	/**
	 * 获取：会员卡号
	 */
	public String getVipcardno() {
		return vipcardno;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：学校
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/**
	 * 获取：学校
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * 设置：第几届
	 */
	public void setSession(String session) {
		this.session = session;
	}
	/**
	 * 获取：第几届
	 */
	public String getSession() {
		return session;
	}
	/**
	 * 设置：专业
	 */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	/**
	 * 获取：专业
	 */
	public String getSpecialty() {
		return specialty;
	}
	/**
	 * 设置：关系分类
	 */
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	/**
	 * 获取：关系分类
	 */
	public String getRelationship() {
		return relationship;
	}
	/**
	 * 设置：会员卡状态
	 */
	public void setVipcardstate(String vipcardstate) {
		this.vipcardstate = vipcardstate;
	}
	/**
	 * 获取：会员卡状态
	 */
	public String getVipcardstate() {
		return vipcardstate;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
	}
}
