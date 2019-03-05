package com.dreamershaven.design.vo;
/**
 * DISC统计对象
 * @author dongyaxin
 *
 */
public class DiscStatVO {
	/**
	 * 用户总数
	 */
	private Integer usersNum;
	/**
	 * 测试总数
	 */
	private Integer testsNum;
	public Integer getUsersNum() {
		return usersNum;
	}
	public void setUsersNum(Integer usersNum) {
		this.usersNum = usersNum;
	}
	public Integer getTestsNum() {
		return testsNum;
	}
	public void setTestsNum(Integer testsNum) {
		this.testsNum = testsNum;
	}
	
}
