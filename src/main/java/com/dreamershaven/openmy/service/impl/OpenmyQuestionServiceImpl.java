package com.dreamershaven.openmy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.openmy.service.OpenmyQuestionService;
import com.dreamershaven.wechat.bean.OpenmyQuestionDO;
import com.dreamershaven.wechat.mapper.OpenmyQuestionMapper;



@Service
public class OpenmyQuestionServiceImpl implements OpenmyQuestionService {
	@Autowired
	private OpenmyQuestionMapper openmyQuestionDao;
	
	@Override
	public OpenmyQuestionDO get(Long id){
		return openmyQuestionDao.get(id);
	}
	
	@Override
	public List<OpenmyQuestionDO> list(Map<String, Object> map){
		return openmyQuestionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return openmyQuestionDao.count(map);
	}
	
	@Override
	public int save(OpenmyQuestionDO openmyQuestion){
		return openmyQuestionDao.save(openmyQuestion);
	}
	
	@Override
	public int update(OpenmyQuestionDO openmyQuestion){
		return openmyQuestionDao.update(openmyQuestion);
	}
	
	@Override
	public int remove(Long id){
		return openmyQuestionDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return openmyQuestionDao.batchRemove(ids);
	}
	
}
