package com.dreamershaven.wechat.service;

import java.util.List;

import com.dreamershaven.wechat.bean.Space;



public interface SpaceService {
	Space getSpaceById(Integer id);
	 
	public List<Space> getSpaceList();
 
	public int add(Space space);
 
	public int update(Integer id, Space space);
 
	public int delete(Integer id);
	
	public StringBuffer buildWechatInfo();

}
