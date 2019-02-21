package com.dreamershaven.wechat.bean;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-02-21 09:48:23
 */
public class DesignTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//DISC类型
	private String discType;
	//中文名称
	private String cname;
	//测评结果概述
	private String evaDesc;
	//英文名称
	private String ename;
	//行为特征
	private String behaChara;
	//交流沟通
	private String communicate;
	//能力特征
	private String ability;
	//行为优势
	private String superiority;
	//行为弱势
	private String vulnerable;
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
	 * 设置：中文名称
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * 获取：中文名称
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * 设置：测评结果概述
	 */
	public void setEvaDesc(String evaDesc) {
		this.evaDesc = evaDesc;
	}
	/**
	 * 获取：测评结果概述
	 */
	public String getEvaDesc() {
		return evaDesc;
	}
	/**
	 * 设置：英文名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * 获取：英文名称
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * 设置：行为特征
	 */
	public void setBehaChara(String behaChara) {
		this.behaChara = behaChara;
	}
	/**
	 * 获取：行为特征
	 */
	public String getBehaChara() {
		return behaChara;
	}
	/**
	 * 设置：交流沟通
	 */
	public void setCommunicate(String communicate) {
		this.communicate = communicate;
	}
	/**
	 * 获取：交流沟通
	 */
	public String getCommunicate() {
		return communicate;
	}
	/**
	 * 设置：能力特征
	 */
	public void setAbility(String ability) {
		this.ability = ability;
	}
	/**
	 * 获取：能力特征
	 */
	public String getAbility() {
		return ability;
	}
	/**
	 * 设置：行为优势
	 */
	public void setSuperiority(String superiority) {
		this.superiority = superiority;
	}
	/**
	 * 获取：行为优势
	 */
	public String getSuperiority() {
		return superiority;
	}
	/**
	 * 设置：行为弱势
	 */
	public void setVulnerable(String vulnerable) {
		this.vulnerable = vulnerable;
	}
	/**
	 * 获取：行为弱势
	 */
	public String getVulnerable() {
		return vulnerable;
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
