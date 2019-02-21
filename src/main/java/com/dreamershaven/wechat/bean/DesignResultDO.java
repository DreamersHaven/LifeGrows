package com.dreamershaven.wechat.bean;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-01-24 18:36:43
 */
@ApiModel(value="DISC对象",description="这是DISC结果对象")
public class DesignResultDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	@ApiModelProperty(hidden=true)
	private Long id;
	//用户标识ID
	@ApiModelProperty(value="用户ID",name="userId",example="14",required=true)
	private Long userId;
	//用户名
	@ApiModelProperty(value="用户名",name="username",example="dongyaxin",required=true)
	private String username;
	//内在图
	@ApiModelProperty(hidden=true)
	private String inPicId;
	//外在图
	@ApiModelProperty(hidden=true)
	private String outPicId;
	//受压图
	@ApiModelProperty(hidden=true)
	private String prePicId;
	//测评结果描述
	@ApiModelProperty(hidden=true)
	private String evaDesc;
	//创建时间
	@ApiModelProperty(hidden=true)
	private Date gmtCreate;
	// 状态
	@ApiModelProperty(hidden=true)
	private Integer status;
	//最符合DISC结果，以逗号分隔
	@ApiModelProperty(value="最符合DISC结果",name="mresult",example="16,7,2,3",required=true)
	private String mresult;
	//最不符合DISC测试结果
	@ApiModelProperty(value="最不符合DISC测试结果",name="lresult",example="4,7,12,6",required=true)
	private String lresult;
	//相减DISC测试结果
	@ApiModelProperty(value="相减DISC测试结果",name="aresult",example="12,0,-10,-3",required=true)
	private String aresult;
	//DISC类型
	@ApiModelProperty(value="DISC类型",name="discType",example="DI",required=true)
	private String discType;
	//最符合DISC结果对应的坐标值，以逗号分隔
	@ApiModelProperty(value="最符合DISC结果对应的坐标值",name="yvalue",example="16,7,2,3",required=true)
	private String yvalue;

	public String getYvalue() {
		return yvalue;
	}
	public void setYvalue(String yvalue) {
		this.yvalue = yvalue;
	}
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
	public void setprePicId(String pPicId) {
		this.prePicId = pPicId;
	}
	/**
	 * 获取：受压图
	 */
	public String getPrePicId() {
		return prePicId;
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
	public void setMresult(String mResult) {
		this.mresult = mResult;
	}
	/**
	 * 获取：最符合DISC结果，以逗号分隔
	 */
	public String getMresult() {
		return mresult;
	}
	/**
	 * 设置：最不符合DISC测试结果
	 */
	public void setLresult(String lResult) {
		this.lresult = lResult;
	}
	/**
	 * 获取：最不符合DISC测试结果
	 */
	public String getLresult() {
		return lresult;
	}
	/**
	 * 设置：相减DISC测试结果
	 */
	public void setAresult(String aResult) {
		this.aresult = aResult;
	}
	/**
	 * 获取：相减DISC测试结果
	 */
	public String getAresult() {
		return aresult;
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
