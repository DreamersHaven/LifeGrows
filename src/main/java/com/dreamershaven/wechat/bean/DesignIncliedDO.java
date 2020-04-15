package com.dreamershaven.wechat.bean;

import java.io.Serializable;



/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-06-04 16:53:46
 */
public class DesignIncliedDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//DISC类型
	private String discType;
	//行为类别
	private String kindName;
	//行为描述
	private String inclied;
	//行为标记（1优势；2劣势）
	private String tagged;
	//备用字段1
	private String backup1;
	//备用字段2
	private String backup2;

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
	 * 设置：备用字段1
	 */
	public void setBackup1(String backup1) {
		this.backup1 = backup1;
	}
	/**
	 * 获取：备用字段1
	 */
	public String getBackup1() {
		return backup1;
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
}
