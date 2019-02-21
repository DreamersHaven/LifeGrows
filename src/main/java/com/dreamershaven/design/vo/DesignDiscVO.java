package com.dreamershaven.design.vo;
/**
 * DISC 坐标对象，不是实体对象
 *  用于判断用户性格类型的临时对象
 * @author dongyaxin
 *
 */
public class DesignDiscVO {
	//y抽坐标值
	private double yValue;
	//DISC类型
	private String type;
	//平均值
	private String avgValue;
	//DISC数值
	private int discValue;
	public double getyValue() {
		return yValue;
	}
	public void setyValue(double yValue) {
		this.yValue = yValue;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAvgValue() {
		return avgValue;
	}
	public void setAvgValue(String avgValue) {
		this.avgValue = avgValue;
	}
	public int getDiscValue() {
		return discValue;
	}
	public void setDiscValue(int discValue) {
		this.discValue = discValue;
	}
}
