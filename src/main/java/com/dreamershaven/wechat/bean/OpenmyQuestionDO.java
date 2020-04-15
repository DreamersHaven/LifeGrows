package com.dreamershaven.wechat.bean;

import java.io.Serializable;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-04-07 14:35:18
 */
public class OpenmyQuestionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//用户ID
	private String userId;
	//探索问题
	private String questions;
	//问题序号
	private Integer numOrder;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：探索问题
	 */
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	/**
	 * 获取：探索问题
	 */
	public String getQuestions() {
		return questions;
	}
	/**
	 * 设置：问题序号
	 */
	public void setNumOrder(Integer numOrder) {
		this.numOrder = numOrder;
	}
	/**
	 * 获取：问题序号
	 */
	public Integer getNumOrder() {
		return numOrder;
	}
}
