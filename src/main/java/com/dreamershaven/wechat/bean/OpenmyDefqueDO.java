package com.dreamershaven.wechat.bean;

import java.io.Serializable;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-04-07 14:35:10
 */
public class OpenmyDefqueDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//问题序号
	private Integer numOrder;
	//探索问题
	private String questions;

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
}
