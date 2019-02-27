package com.dreamershaven.design.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dreamershaven.wechat.bean.DesignUserDO;
import com.dreamershaven.wechat.mapper.DesignUserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private DesignUserMapper designUserMapper;

	
	public boolean queryUsernameIsExist(String username) {
		
		Map<String, Object> query = new HashMap<>(16);
		query.put("username", username);
		List<DesignUserDO> designUserDOs=designUserMapper.list(query);
		if(designUserDOs!=null&&designUserDOs.size()>0) {
			return true;
		}
			
		return false;
	}

	
	public void saveUser(DesignUserDO user) {
		designUserMapper.save(user);

	}


	
	public DesignUserDO queryUserForLogin(String username, String password) {
		Map<String, Object> query = new HashMap<>(16);
		query.put("username", username);
		query.put("password", password);
		List<DesignUserDO> designUserDOs=designUserMapper.list(query);
		if(designUserDOs!=null&&designUserDOs.size()>0) {
			return designUserDOs.get(0);
		}else {
			return null;
		}
	}


	
	public void updateUserInfo(DesignUserDO user) {
		
		designUserMapper.update(user);
		
	}


	 
	public DesignUserDO queryUserInfo(String userId) {
		Map<String, Object> query = new HashMap<>(16);
		query.put("userId", userId);
		List<DesignUserDO> designUserDOs=designUserMapper.list(query);
		if(designUserDOs!=null&&designUserDOs.size()>0) {
			return designUserDOs.get(0);
		}
			
		return null;
	}


	
	public DesignUserDO queryUserWxIsExist(String userWx) {
		//wxId
		Map<String, Object> query = new HashMap<>(16);
		query.put("wxId", userWx);
		List<DesignUserDO> designUserDOs=designUserMapper.list(query);
		if(designUserDOs!=null&&designUserDOs.size()>0) {
			return designUserDOs.get(0);
		}
		return null;
	}

}
