package com.dreamershaven.wechat.bean;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-01-20 19:59:36
 */
public class DesignResultDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//用户标识ID
	private Long userId;
	//用户名
	private String username;
	//内在图
	private String inPicId;
	//外在图
	private String outPicId;
	//受压图
	private String pPicId;
	//测评结果描述
	private String evaDesc;
	//创建时间
	private Date gmtCreate;
	// 状态
	private Integer status;

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
	 * 设置：用户标识ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户标识ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：内在图
	 */
	public void setInPicId(String inPicId) {
		this.inPicId = inPicId;
	}
	/**
	 * 获取：内在图
	 */
	public String getInPicId() {
		return inPicId;
	}
	/**
	 * 设置：外在图
	 */
	public void setOutPicId(String outPicId) {
		this.outPicId = outPicId;
	}
	/**
	 * 获取：外在图
	 */
	public String getOutPicId() {
		return outPicId;
	}
	/**
	 * 设置：受压图
	 */
	public void setPPicId(String pPicId) {
		this.pPicId = pPicId;
	}
	/**
	 * 获取：受压图
	 */
	public String getPPicId() {
		return pPicId;
	}
	/**
	 * 设置：测评结果描述
	 */
	public void setEvaDesc(String evaDesc) {
		this.evaDesc = evaDesc;
	}
	/**
	 * 获取：测评结果描述
	 */
	public String getEvaDesc() {
		return evaDesc;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 设置： 状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取： 状态
	 */
	public Integer getStatus() {
		return status;
	}
}
