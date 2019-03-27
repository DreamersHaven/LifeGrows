package com.dreamershaven.design.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.design.service.SwitchService;
import com.dreamershaven.wechat.bean.SwitchDO;
import com.dreamershaven.wechat.mapper.SwitchMapper;



@Service
public class SwitchServiceImpl implements SwitchService {
	@Autowired
	private SwitchMapper switchDao;
	
	@Override
	public SwitchDO get(Integer id){
		return switchDao.get(id);
	}
	
	@Override
	public List<SwitchDO> list(Map<String, Object> map){
		return switchDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return switchDao.count(map);
	}
	
	@Override
	public int save(SwitchDO switchdo){
		return switchDao.save(switchdo);
	}
	
	@Override
	public int update(SwitchDO switchdo){
		return switchDao.update(switchdo);
	}
	
	@Override
	public int remove(Integer id){
		return switchDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return switchDao.batchRemove(ids);
	}

	@Override
	public int updateOpenState(SwitchDO switchdo) {
		 
		return switchDao.updateOpenState(switchdo);
	}
	
}
