package com.dreamershaven.design.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.design.vo.DiscStatByDiscTypeVO;
import com.dreamershaven.design.vo.DiscStatVO;
import com.dreamershaven.wechat.mapper.DesignResultMapper;
import com.dreamershaven.wechat.mapper.DesignUserMapper;
@Service
public class StatServiceImpl implements StatService{
	
	@Autowired
	private DesignResultMapper designResultMapper;
	@Autowired
	private DesignUserMapper designUserMapper;
	public DiscStatVO stat() {
		int testsNum=designResultMapper.count(null);
		int usersNum=designUserMapper.count(null);
		DiscStatVO discStatVO=new DiscStatVO();
		discStatVO.setTestsNum(testsNum);
		discStatVO.setUsersNum(usersNum);
		
		return discStatVO;
	}
	
	@Override
	public List<DiscStatByDiscTypeVO> countNumsGroupByDiscType() {
		List<DiscStatByDiscTypeVO> discStatByDiscTypeVOs=designResultMapper.countNums();
		
		return discStatByDiscTypeVOs;
	}

}
