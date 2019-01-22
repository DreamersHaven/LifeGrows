package com.dreamershaven.wechat.bean;

import java.io.Serializable;



/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-08-05 10:32:36
 */
public class RespMsgDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//序号
	private Integer msgId;
	//消息类型
	private String msgType;
	//图文标题
	private String title;
	//图文描述
	private String description;
	//图片URL
	private String picUrl;
	//图文链接
	private String url;
	//文本内容
	private String content;
	//
	private Integer funcFlag;
	//关键字
	private String keyWord;
	//关键字匹配类型
	private String keyWordType;
	// 用户发送消息类型
	private String reqMsgType;

	/**
	 * 设置：序号
	 */
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	/**
	 * 获取：序号
	 */
	public Integer getMsgId() {
		return msgId;
	}
	/**
	 * 设置：消息类型
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	/**
	 * 获取：消息类型
	 */
	public String getMsgType() {
		return msgType;
	}
	/**
	 * 设置：图文标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：图文标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：图文描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：图文描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：图片URL
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	/**
	 * 获取：图片URL
	 */
	public String getPicUrl() {
		return picUrl;
	}
	/**
	 * 设置：图文链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：图文链接
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：文本内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：文本内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：
	 */
	public void setFuncFlag(Integer funcFlag) {
		this.funcFlag = funcFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getFuncFlag() {
		return funcFlag;
	}
	/**
	 * 设置：关键字
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	/**
	 * 获取：关键字
	 */
	public String getKeyWord() {
		return keyWord;
	}
	/**
	 * 设置：关键字匹配类型
	 */
	public void setKeyWordType(String keyWordType) {
		this.keyWordType = keyWordType;
	}
	/**
	 * 获取：关键字匹配类型
	 */
	public String getKeyWordType() {
		return keyWordType;
	}
	/**
	 * 设置： 用户发送消息类型
	 */
	public void setReqMsgType(String reqMsgType) {
		this.reqMsgType = reqMsgType;
	}
	/**
	 * 获取： 用户发送消息类型
	 */
	public String getReqMsgType() {
		return reqMsgType;
	}
}
