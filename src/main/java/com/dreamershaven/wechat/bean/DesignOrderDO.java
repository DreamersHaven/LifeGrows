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
 * @date 2019-03-26 20:43:22
 */
@ApiModel(value="DISC订单对象",description="这是DISC订单对象")
public class DesignOrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="用户ID",name="userId",example="14",required=true)
	private Long userId;
	//用户名
	@ApiModelProperty(value="用户姓名",name="username",example="董亚欣",required=true)
	private String username;
	//状态：1、未付款；2、已付款；5、交易成功；6、交易关闭
	private Integer status;
	//创建时间
	private Date gmtCreate;
	//微信ID
	@ApiModelProperty(value="用户微信ID",name="wxId",example="oWs2o5WAv1v9LrnWjwWzKbO2PggY",required=true)
	private String wxId;
	//订单id
	@ApiModelProperty(hidden=true)
	private Long orderId;
	//实付金额
	@ApiModelProperty(value="实付金额",name="payment",example="1",required=true)
	private String payment;
	//订单编号
	private String orderNum;
	//消费项目
	@ApiModelProperty(value="消费项目",name="consumerItem",example="详细测试报告",required=true)
	private String consumerItem;

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
	 * 设置：状态：1、未付款；2、已付款；5、交易成功；6、交易关闭
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态：1、未付款；2、已付款；5、交易成功；6、交易关闭
	 */
	public Integer getStatus() {
		return status;
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
	/**
	 * 设置：订单id
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单id
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：实付金额
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}
	/**
	 * 获取：实付金额
	 */
	public String getPayment() {
		return payment;
	}
	/**
	 * 设置：订单编号
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：消费项目
	 */
	public void setConsumerItem(String consumerItem) {
		this.consumerItem = consumerItem;
	}
	/**
	 * 获取：消费项目
	 */
	public String getConsumerItem() {
		return consumerItem;
	}
}
