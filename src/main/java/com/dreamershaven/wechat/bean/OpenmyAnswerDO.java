package com.dreamershaven.wechat.bean;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 
 * 
 * @author dongyaxin
 * @date 2020-04-07 14:35:00
 */
@ApiModel(value="反馈结果对象",description="这是别人对自己的反馈结果对象")
public class OpenmyAnswerDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	@ApiModelProperty(hidden=true)
	private Long id;
	//用户ID
	@ApiModelProperty(value="用户ID",name="userId",example="14",required=true)
	private String userId;
	//探索问题id
	@ApiModelProperty(hidden=true)
	private Integer questionsId;
	
	@ApiModelProperty(value="探索问题id",name="questions",example="1#2#3#4",required=true)
	private String questions;
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	//问题答案
	@ApiModelProperty(value="问题答案",name="answer",example="自信、乐观、幽默#你很有同理心#特别棒#文案和程序相关的问题会想让你帮忙",required=true)
	private String answer;
	//反馈日期
	@ApiModelProperty(hidden=true)
	private Date feedbackTime;
	//组序号（1个人为一组）
	@ApiModelProperty(hidden=true)
	private Integer groupId;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
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
	 * 设置：探索问题id
	 */
	public void setQuestionsId(Integer questionsId) {
		this.questionsId = questionsId;
	}
	/**
	 * 获取：探索问题id
	 */
	public Integer getQuestionsId() {
		return questionsId;
	}
	/**
	 * 设置：问题答案
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * 获取：问题答案
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * 设置：反馈日期
	 */
	public void setFeedbackTime(Date feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	/**
	 * 获取：反馈日期
	 */
	public Date getFeedbackTime() {
		return feedbackTime;
	}
	/**
	 * 设置：组序号（1个人为一组）
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	/**
	 * 获取：组序号（1个人为一组）
	 */
	public Integer getGroupId() {
		return groupId;
	}
}
