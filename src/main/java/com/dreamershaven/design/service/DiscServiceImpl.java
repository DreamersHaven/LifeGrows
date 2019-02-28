package com.dreamershaven.design.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.wechat.bean.DesignResultDO;
import com.dreamershaven.wechat.bean.DesignTypeDO;
import com.dreamershaven.wechat.mapper.DesignResultMapper;
@Service
public class DiscServiceImpl implements DiscService {
	
	@Autowired
	private DesignResultMapper designResultMapper;
	@Autowired
	private DiscTypeService discTypeService;
	/**
	 * 保存DISC测评结果
	 * 
	 */
	public void saveResult(DesignResultDO designResultDO) {
		//依据DISC结果，确定DISC类型，并存储到数据库中
		List<DesignResultDO> designResultDOs=this.queryUserDISCInfos(designResultDO.getUserId().toString());
		//每个用户最多保存9条记录
		if(designResultDOs!=null&&designResultDOs.size()>9) {
			DesignResultDO designResultDOtemp=(DesignResultDO)designResultDOs.get(0);
			designResultMapper.remove(designResultDOtemp.getId());
		}
		DesignTypeDO designTypeDO=discTypeService.queryUserDISCInfo(designResultDO.getYvalue(), designResultDO.getMresult(), "M");
		if(designTypeDO!=null) {
			designResultDO.setDiscType(designTypeDO.getDiscType());
			designResultDO.setEvaDesc(designTypeDO.getEvaDesc().substring(17));
		}
		
		
		designResultMapper.save(designResultDO);
	}
	
	 
	public DesignResultDO queryUserDISCInfo(String userId) {
		Map<String, Object> query = new HashMap<>(16);
		query.put("userId", userId);
		List<DesignResultDO> designResultDOs=designResultMapper.list(query);
		if(designResultDOs!=null&&designResultDOs.size()>0) {
			return designResultDOs.get(0);
		}
			
		return null;
	}


	@Override
	public List<DesignResultDO> queryUserDISCInfos(String userId) {
		Map<String, Object> query = new HashMap<>(16);
		query.put("userId", userId);
		List<DesignResultDO> designResultDOs=designResultMapper.list(query);
		if(designResultDOs!=null&&designResultDOs.size()>0) {
			return designResultDOs;
		}
			
		return null;
	}

}
