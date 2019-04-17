package com.dreamershaven.design.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.design.service.DesignCollectService;
import com.dreamershaven.wechat.bean.DesignCollectDO;
import com.dreamershaven.wechat.bean.DesignUserDO;
import com.dreamershaven.wechat.mapper.DesignCollectMapper;



@Service
public class DesignCollectServiceImpl implements DesignCollectService {
	@Autowired
	private DesignCollectMapper designCollectDao;
	
	@Override
	public DesignCollectDO get(Long id){
		return designCollectDao.get(id);
	}
	
	@Override
	public List<DesignCollectDO> list(Map<String, Object> map){
		return designCollectDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return designCollectDao.count(map);
	}
	
	@Override
	public int save(DesignCollectDO designCollect){
		return designCollectDao.save(designCollect);
	}
	
	@Override
	public int update(DesignCollectDO designCollect){
		return designCollectDao.update(designCollect);
	}
	
	@Override
	public int remove(Long id){
		return designCollectDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return designCollectDao.batchRemove(ids);
	}

	@Override
	public List<DesignUserDO> getUserInfosByCollect(String userId) {
		long l=Long.parseLong(userId);
		return designCollectDao.getUserInfosByCollect(l);
	}
	
}
