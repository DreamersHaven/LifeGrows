package com.dreamershaven.wechat.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-03-26 16:41:46
 */
@ApiModel(value="系统开关对象",description="管理员用户可以通过设置系统开关，对系统进行设置")
public class SwitchDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//开关英文名称
	@ApiModelProperty(value="开关英文名称",name="keyvalue",example="wc_payment",required=true)
	private String keyvalue;
	//主键
	@ApiModelProperty(hidden=true)
	private Integer id;
	//开关名称
	@ApiModelProperty(value="开关中文名称",name="keyname",example="收费开关",required=true)
	private String keyname;
	//开关（0：关闭；1：打开）
	@ApiModelProperty(value="开关值",name="isopen",example="1",required=true)
	private Boolean isopen;

	/**
	 * 设置：开关英文名称
	 */
	public void setKeyvalue(String keyvalue) {
		this.keyvalue = keyvalue;
	}
	/**
	 * 获取：开关英文名称
	 */
	public String getKeyvalue() {
		return keyvalue;
	}
	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：开关名称
	 */
	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}
	/**
	 * 获取：开关名称
	 */
	public String getKeyname() {
		return keyname;
	}
	/**
	 * 设置：开关（0：关闭；1：打开）
	 */
	public void setIsopen(Boolean isopen) {
		this.isopen = isopen;
	}
	/**
	 * 获取：开关（0：关闭；1：打开）
	 */
	public Boolean getIsopen() {
		return isopen;
	}
}
