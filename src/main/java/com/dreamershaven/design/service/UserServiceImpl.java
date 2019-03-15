package com.dreamershaven.design.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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


	
	public List<DesignUserDO> queryUserList(DesignUserDO user) {
		//如果依据用户名进行查询
		Map<String, Object> query = new HashMap<>(16);
		
		if(user!=null&&user.getUsername()!=null&&!"".equals(user.getUsername())) {
			query.put("username", user.getUsername());
		}
		List<DesignUserDO> designUserDOs=designUserMapper.list(query);
		if(designUserDOs!=null&&designUserDOs.size()>0) {
			return designUserDOs;
		}
		return null;
	}


	public IPage<DesignUserDO> selectPageExt(DesignUserDO user, int page, int pageSize) throws RuntimeException {
	    try {
	        Page<DesignUserDO> p = new Page<>(page, pageSize);
	        p.setRecords(designUserMapper.selectPageExt(p, user));
	        return p;
	    } catch (Exception e) {
	        throw new RuntimeException(e.getMessage());
	    }
	}


}
