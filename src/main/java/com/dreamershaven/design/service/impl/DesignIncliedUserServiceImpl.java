package com.dreamershaven.design.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.design.service.DesignIncliedUserService;
import com.dreamershaven.wechat.bean.DesignIncliedUserDO;
import com.dreamershaven.wechat.mapper.DesignIncliedUserMapper;



@Service
public class DesignIncliedUserServiceImpl implements DesignIncliedUserService {
	@Autowired
	private DesignIncliedUserMapper designIncliedUserDao;
	
	@Override
	public DesignIncliedUserDO get(Long id){
		return designIncliedUserDao.get(id);
	}
	
	@Override
	public List<DesignIncliedUserDO> list(Map<String, Object> map){
		return designIncliedUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return designIncliedUserDao.count(map);
	}
	
	@Override
	public int save(DesignIncliedUserDO designIncliedUser){
		return designIncliedUserDao.save(designIncliedUser);
	}
	
	@Override
	public int update(DesignIncliedUserDO designIncliedUser){
		return designIncliedUserDao.update(designIncliedUser);
	}
	
	@Override
	public int remove(Long id){
		return designIncliedUserDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return designIncliedUserDao.batchRemove(ids);
	}

	@Override
	public int batchSave(List<DesignIncliedUserDO> designIncliedUserDOs) {
		
		return designIncliedUserDao.batchSave(designIncliedUserDOs);
	}
	
}
