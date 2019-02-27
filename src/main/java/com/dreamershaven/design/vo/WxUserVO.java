package com.dreamershaven.design.vo;
/**
 * 微信信息，不是实体对象
 *  用于存储用户授权的微信信息
 * @author dongyaxin
 *
 */
public class WxUserVO {
	private String code;
	private String nickName;
	private String city;
	private String province;
	private String avatarUrl;
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
