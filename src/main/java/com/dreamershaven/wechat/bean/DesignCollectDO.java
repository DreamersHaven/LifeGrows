package com.dreamershaven.wechat.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-04-16 18:07:03
 */
@ApiModel(value="用户收藏对象",description="这是用户收藏对象")
public class DesignCollectDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	@ApiModelProperty(hidden=true)
	private Long id;
	//用户标识ID
	@ApiModelProperty(value="用户ID",name="userId",example="14",required=true)
	private Long userId;
	//收藏的测试报告ID
	@ApiModelProperty(value="测试报告ID",name="collectreportId",example="14",required=false)
	private Long collectreportId;
	//测试报告类型（图形，报告，图形和报告）
	@ApiModelProperty(value="测试报告类型",name="reportType",example="all",required=false)
	private String reportType;
	//被收藏的用户ID
	@ApiModelProperty(value="被收藏的用户ID",name="collectuserId",example="16",required=true)
	private Long collectuserId;
	//被收藏的用户备注名
	@ApiModelProperty(value="被收藏的用户备注名",name="collectuserName",example="第7期人生设计师学员",required=false)
	private String collectuserName;

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
	 * 设置：收藏的测试报告ID
	 */
	public void setCollectreportId(Long collectreportId) {
		this.collectreportId = collectreportId;
	}
	/**
	 * 获取：收藏的测试报告ID
	 */
	public Long getCollectreportId() {
		return collectreportId;
	}
	/**
	 * 设置：测试报告类型（图形，报告，图形和报告）
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	/**
	 * 获取：测试报告类型（图形，报告，图形和报告）
	 */
	public String getReportType() {
		return reportType;
	}
	/**
	 * 设置：被收藏的用户ID
	 */
	public void setCollectuserId(Long collectuserId) {
		this.collectuserId = collectuserId;
	}
	/**
	 * 获取：被收藏的用户ID
	 */
	public Long getCollectuserId() {
		return collectuserId;
	}
	/**
	 * 设置：被收藏的用户备注名
	 */
	public void setCollectuserName(String collectuserName) {
		this.collectuserName = collectuserName;
	}
	/**
	 * 获取：被收藏的用户备注名
	 */
	public String getCollectuserName() {
		return collectuserName;
	}
}
