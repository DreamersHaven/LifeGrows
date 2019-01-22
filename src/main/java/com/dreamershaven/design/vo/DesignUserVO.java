package com.dreamershaven.design.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-12-26 18:35:54
 */
@ApiModel(value="用户对象",description="这是用户对象")
public class DesignUserVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(hidden=true)
	private Long userId;
	//用户名
	@ApiModelProperty(value="用户名",name="username",example="dongyaxin",required=true)
	
	private String userToken;
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	//
	private String name;
	
	private String username;
	//密码
	@ApiModelProperty(value="密码",name="password",example="123456",required=true)
	private String password;
	//
	@ApiModelProperty(hidden=true)
	private Long deptId;
	//邮箱
	@ApiModelProperty(hidden=true)
	private String email;
	//手机号
	@ApiModelProperty(hidden=true)
	private String mobile;
	//状态 0:禁用，1:正常
	@ApiModelProperty(hidden=true)
	private Integer status;
	//创建用户id
	@ApiModelProperty(hidden=true)
	private Long userIdCreate;
	//创建时间
	@ApiModelProperty(hidden=true)
	private Date gmtCreate;
	//修改时间
	@ApiModelProperty(hidden=true)
	private Date gmtModified;
	//性别
	@ApiModelProperty(hidden=true)
	private Long sex;
	//出身日期
	@ApiModelProperty(hidden=true)
	private Date birth;
	//
	@ApiModelProperty(hidden=true)
	private Long picId;
	//现居住地
	@ApiModelProperty(hidden=true)
	private String liveAddress;
	//爱好
	@ApiModelProperty(hidden=true)
	private String hobby;
	//省份
	@ApiModelProperty(hidden=true)
	private String province;
	//所在城市
	@ApiModelProperty(hidden=true)
	private String city;
	//所在地区
	@ApiModelProperty(hidden=true)
	private String district;
	//微信ID
	@ApiModelProperty(hidden=true)
	private String wxId;

	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
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
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：状态 0:禁用，1:正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0:禁用，1:正常
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：创建用户id
	 */
	public void setUserIdCreate(Long userIdCreate) {
		this.userIdCreate = userIdCreate;
	}
	/**
	 * 获取：创建用户id
	 */
	public Long getUserIdCreate() {
		return userIdCreate;
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
	 * 设置：修改时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(Long sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public Long getSex() {
		return sex;
	}
	/**
	 * 设置：出身日期
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	/**
	 * 获取：出身日期
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * 设置：
	 */
	public void setPicId(Long picId) {
		this.picId = picId;
	}
	/**
	 * 获取：
	 */
	public Long getPicId() {
		return picId;
	}
	/**
	 * 设置：现居住地
	 */
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}
	/**
	 * 获取：现居住地
	 */
	public String getLiveAddress() {
		return liveAddress;
	}
	/**
	 * 设置：爱好
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	/**
	 * 获取：爱好
	 */
	public String getHobby() {
		return hobby;
	}
	/**
	 * 设置：省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：所在城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：所在城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：所在地区
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * 获取：所在地区
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * 设置：微信ID
	 */
	public void setWxId(String wxId) {
		this.wxId = wxId;
	}
	/**
	 * 获取：微信ID
	 */
	public String getWxId() {
		return wxId;
	}
}
