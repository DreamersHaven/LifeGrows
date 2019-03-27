package com.dreamershaven.design.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.design.service.DesignOrderService;
import com.dreamershaven.wechat.bean.DesignOrderDO;
import com.dreamershaven.wechat.mapper.DesignOrderMapper;



@Service
public class DesignOrderServiceImpl implements DesignOrderService {
	@Autowired
	private DesignOrderMapper designOrderDao;
	
	@Override
	public DesignOrderDO get(Long orderId){
		return designOrderDao.get(orderId);
	}
	
	@Override
	public List<DesignOrderDO> list(Map<String, Object> map){
		return designOrderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return designOrderDao.count(map);
	}
	
	@Override
	public int save(DesignOrderDO designOrder){
		return designOrderDao.save(designOrder);
	}
	
	@Override
	public int update(DesignOrderDO designOrder){
		return designOrderDao.update(designOrder);
	}
	
	@Override
	public int remove(Long orderId){
		return designOrderDao.remove(orderId);
	}
	
	@Override
	public int batchRemove(Long[] orderIds){
		return designOrderDao.batchRemove(orderIds);
	}
	
}
