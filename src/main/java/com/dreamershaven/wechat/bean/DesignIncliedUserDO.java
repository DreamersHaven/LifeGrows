package com.dreamershaven.wechat.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;



/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-06-22 20:39:38
 */
public class DesignIncliedUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	@ApiModelProperty(hidden=true)
	private Long id;
	//DISC类型
	@ApiModelProperty(value="DISC类型",name="discType",example="D",required=true)
	private String discType;
	//行为类别
	@ApiModelProperty(value="行为类别",name="kindName",example="工作性格",required=true)
	private String kindName;
	//行为描述
	@ApiModelProperty(value="行为描述",name="inclied",example="目标导向",required=true)
	private String inclied;
	//行为标记（1优势；2劣势）
	@ApiModelProperty(value="行为标记（1优势；2劣势）",name="tagged",example="1",required=true)
	private String tagged;
	//用户评级(1-5星)
	@ApiModelProperty(value="用户评级(1-5星)",name="userRating",example="5",required=true)
	private String userRating;
	//备用字段2
	@ApiModelProperty(hidden=true)
	private String backup2;
	//用户ID
	@ApiModelProperty(value="用户ID",name="userId",example="14",required=true)
	private Long userId;
	//用户姓名
	@ApiModelProperty(value="用户姓名",name="userName",example="董亚欣",required=true)
	private String userName;

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
	/**
	 * 设置：行为类别
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	/**
	 * 获取：行为类别
	 */
	public String getKindName() {
		return kindName;
	}
	/**
	 * 设置：行为描述
	 */
	public void setInclied(String inclied) {
		this.inclied = inclied;
	}
	/**
	 * 获取：行为描述
	 */
	public String getInclied() {
		return inclied;
	}
	/**
	 * 设置：行为标记（1优势；2劣势）
	 */
	public void setTagged(String tagged) {
		this.tagged = tagged;
	}
	/**
	 * 获取：行为标记（1优势；2劣势）
	 */
	public String getTagged() {
		return tagged;
	}
	/**
	 * 设置：用户评级(1-5星)
	 */
	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}
	/**
	 * 获取：用户评级(1-5星)
	 */
	public String getUserRating() {
		return userRating;
	}
	/**
	 * 设置：备用字段2
	 */
	public void setBackup2(String backup2) {
		this.backup2 = backup2;
	}
	/**
	 * 获取：备用字段2
	 */
	public String getBackup2() {
		return backup2;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getUserName() {
		return userName;
	}
}
