package com.dreamershaven.design.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.wechat.bean.DesignResultDO;
import com.dreamershaven.wechat.mapper.DesignResultMapper;
@Service
public class DiscServiceImpl implements DiscService {
	
	@Autowired
	private DesignResultMapper designResultMapper;
	/**
	 * 保存DISC测评结果
	 * 
	 */
	public void saveResult(DesignResultDO designResultDO) {
		designResultMapper.save(designResultDO);
	}

}
