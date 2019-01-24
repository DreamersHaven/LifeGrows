package com.dreamershaven.wechat.bean;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-01-24 18:36:43
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
	//最符合DISC结果，以逗号分隔
	private String mResult;
	//最不符合DISC测试结果
	private String lResult;
	//相减DISC测试结果
	private String aResult;
	//DISC类型
	private String discType;

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
	/**
	 * 设置：最符合DISC结果，以逗号分隔
	 */
	public void setMResult(String mResult) {
		this.mResult = mResult;
	}
	/**
	 * 获取：最符合DISC结果，以逗号分隔
	 */
	public String getMResult() {
		return mResult;
	}
	/**
	 * 设置：最不符合DISC测试结果
	 */
	public void setLResult(String lResult) {
		this.lResult = lResult;
	}
	/**
	 * 获取：最不符合DISC测试结果
	 */
	public String getLResult() {
		return lResult;
	}
	/**
	 * 设置：相减DISC测试结果
	 */
	public void setAResult(String aResult) {
		this.aResult = aResult;
	}
	/**
	 * 获取：相减DISC测试结果
	 */
	public String getAResult() {
		return aResult;
	}
	/**
	 * 设置：DISC类型
	 */
	public void setDiscType(String discType) {
		this.discType = discType;
	}
	/**
	 * 获取：DISC类型
	 */
	public String getDiscType() {
		return discType;
	}
}
