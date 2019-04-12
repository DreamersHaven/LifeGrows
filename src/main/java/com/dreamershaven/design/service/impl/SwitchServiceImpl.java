package com.dreamershaven.design.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.design.controller.RegistLoginController;
import com.dreamershaven.design.service.SwitchService;
import com.dreamershaven.wechat.bean.SwitchDO;
import com.dreamershaven.wechat.mapper.SwitchMapper;
import com.dreamershaven.wechat.util.RedisOperator;

@Service
public class SwitchServiceImpl implements SwitchService {
	// 增加日志
	private static Logger log = LoggerFactory.getLogger(RegistLoginController.class);
	@Autowired
	private SwitchMapper switchDao;

	@Autowired
	private RedisOperator redis;

	@Override
	public SwitchDO get(Integer id) {
		return switchDao.get(id);
	}

	@Override
	public List<SwitchDO> list(Map<String, Object> map) {
		return switchDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return switchDao.count(map);
	}

	@Override
	public int save(SwitchDO switchdo) {
		return switchDao.save(switchdo);
	}

	@Override
	public int update(SwitchDO switchdo) {
		return switchDao.update(switchdo);
	}

	@Override
	public int remove(Integer id) {
		return switchDao.remove(id);
	}

	@Override
	public int batchRemove(Integer[] ids) {
		return switchDao.batchRemove(ids);
	}

	@Override
	public int updateOpenState(SwitchDO switchdo) {
		String redisKey = "SWITCH_" + switchdo.getKeyvalue();
		String redisIsOpen = switchdo.getIsopen() ? "1" : "0";
		redis.del(redisKey);
		redis.set(redisKey, redisIsOpen);
		return switchDao.updateOpenState(switchdo);
	}

	/**
	 * 首先在redis缓存中查找是否已经缓存了该开关的键值 1、如果已经缓存该键值，直接返回开关的数据
	 * 2、如果没有缓存该数据，从数据库中获取该键值信息，并缓存到redis
	 */
	public Boolean isopen(String keyValue) {
		String redisKey = "SWITCH_" + keyValue;
		String isOpen = redis.get(redisKey);
		if (isOpen != null && !"".equals(isOpen)) {
			log.info("从redis中获取缓存键值：["+keyValue+"]="+isOpen);
			return isOpen.equals("0") ? false : true;
		} else {
			Map<String, Object> query = new HashMap<>(16);
			query.put("keyvalue", keyValue);
			List<SwitchDO> switchDOs = switchDao.list(query);
			if (switchDOs != null && switchDOs.size() > 0) {
				Boolean isOpenValue = switchDOs.get(0).getIsopen();
				String redisIsOpen = isOpenValue ? "1" : "0";
				redis.set(redisKey, redisIsOpen);
				return isOpenValue;
			}
		}
		return false;

	}

}
