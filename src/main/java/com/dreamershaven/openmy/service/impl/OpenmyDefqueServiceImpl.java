package com.dreamershaven.openmy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.openmy.service.OpenmyDefqueService;
import com.dreamershaven.wechat.bean.OpenmyDefqueDO;
import com.dreamershaven.wechat.mapper.OpenmyDefqueMapper;



@Service
public class OpenmyDefqueServiceImpl implements OpenmyDefqueService {
	@Autowired
	private OpenmyDefqueMapper openmyDefqueDao;
	
	@Override
	public OpenmyDefqueDO get(Integer numOrder){
		return openmyDefqueDao.get(numOrder);
	}
	
	@Override
	public List<OpenmyDefqueDO> list(Map<String, Object> map){
		return openmyDefqueDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return openmyDefqueDao.count(map);
	}
	
	@Override
	public int save(OpenmyDefqueDO openmyDefque){
		return openmyDefqueDao.save(openmyDefque);
	}
	
	@Override
	public int update(OpenmyDefqueDO openmyDefque){
		return openmyDefqueDao.update(openmyDefque);
	}
	
	@Override
	public int remove(Integer numOrder){
		return openmyDefqueDao.remove(numOrder);
	}
	
	@Override
	public int batchRemove(Integer[] numOrders){
		return openmyDefqueDao.batchRemove(numOrders);
	}
	
}
