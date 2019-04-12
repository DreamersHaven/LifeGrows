package com.dreamershaven.design.vo;
/**
 * DISC统计对象(按照结果类型查询统计)
 * @author dongyaxin
 *
 */
public class DiscStatByDiscTypeVO {
	private Integer num;
	private String discType;
	private String discTypeName;
	public String getDiscTypeName() {
		return discTypeName;
	}
	public void setDiscTypeName(String discTypeName) {
		this.discTypeName = discTypeName;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getDiscType() {
		return discType;
	}
	public void setDiscType(String discType) {
		this.discType = discType;
	}
	
}
