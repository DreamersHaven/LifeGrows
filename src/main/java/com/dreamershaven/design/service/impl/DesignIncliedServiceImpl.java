package com.dreamershaven.design.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.design.service.DesignIncliedService;
import com.dreamershaven.wechat.bean.DesignIncliedDO;
import com.dreamershaven.wechat.mapper.DesignIncliedMapper;



@Service
public class DesignIncliedServiceImpl implements DesignIncliedService {
	@Autowired
	private DesignIncliedMapper designIncliedDao;
	
	@Override
	public DesignIncliedDO get(Long id){
		return designIncliedDao.get(id);
	}
	
	@Override
	public List<DesignIncliedDO> list(Map<String, Object> map){
		
		return designIncliedDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return designIncliedDao.count(map);
	}
	
	@Override
	public int save(DesignIncliedDO designInclied){
		return designIncliedDao.save(designInclied);
	}
	
	@Override
	public int update(DesignIncliedDO designInclied){
		return designIncliedDao.update(designInclied);
	}
	
	@Override
	public int remove(Long id){
		return designIncliedDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return designIncliedDao.batchRemove(ids);
	}

	 
	public List<DesignIncliedDO> queryByDISC(String discType) {
		
		Map<String, Object> query = new HashMap<>(16);
		query.put("discType", discType);
		List<DesignIncliedDO> designIncliedDOs=designIncliedDao.list(query);	
		return designIncliedDOs;
	}
	
}
