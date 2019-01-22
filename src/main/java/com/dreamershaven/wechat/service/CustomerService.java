package com.dreamershaven.wechat.service;

public interface CustomerService {
	public int customerInsert(String toUserName,String fromUserName, String kfAccount,String accessToken);
	public String customerInsert(String toUserName,String fromUserName);
}
