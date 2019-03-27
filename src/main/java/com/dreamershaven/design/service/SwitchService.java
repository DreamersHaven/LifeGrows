package com.dreamershaven.design.service;

import java.util.List;
import java.util.Map;

import com.dreamershaven.wechat.bean.SwitchDO;

/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-03-26 16:41:46
 */
public interface SwitchService {
	
	SwitchDO get(Integer id);
	
	List<SwitchDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SwitchDO switchdo);
	
	int update(SwitchDO switchdo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	
	int updateOpenState(SwitchDO switchdo);
}
