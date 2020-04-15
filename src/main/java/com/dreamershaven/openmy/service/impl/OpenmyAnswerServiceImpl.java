package com.dreamershaven.openmy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.openmy.service.OpenmyAnswerService;
import com.dreamershaven.wechat.bean.OpenmyAnswerDO;
import com.dreamershaven.wechat.mapper.OpenmyAnswerMapper;

@Service
public class OpenmyAnswerServiceImpl implements OpenmyAnswerService {
	@Autowired
	private OpenmyAnswerMapper openmyAnswerDao;

	@Override
	public OpenmyAnswerDO get(Long id) {
		return openmyAnswerDao.get(id);
	}

	@Override
	public List<OpenmyAnswerDO> list(Map<String, Object> map) {
		return openmyAnswerDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {

		return openmyAnswerDao.count(map);
	}

	@Override
	public int save(OpenmyAnswerDO openmyAnswer) {
		return openmyAnswerDao.save(openmyAnswer);
	}

	@Override
	public int update(OpenmyAnswerDO openmyAnswer) {
		return openmyAnswerDao.update(openmyAnswer);
	}

	@Override
	public int remove(Long id) {
		return openmyAnswerDao.remove(id);
	}

	@Override
	public int batchRemove(Long[] ids) {
		return openmyAnswerDao.batchRemove(ids);
	}

	@Override
	public int maxGroupId(Map<String, Object> map) {
		// 考虑返回结果为null的情况
		List<OpenmyAnswerDO> restult = openmyAnswerDao.list(map);
		if(restult==null||restult.size()==0) {
			return 0;
		}
		return openmyAnswerDao.maxGroupId(map);
	}

}
