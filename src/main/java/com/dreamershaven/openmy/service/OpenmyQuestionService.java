package com.dreamershaven.openmy.service;

import java.util.List;
import java.util.Map;

import com.dreamershaven.wechat.bean.OpenmyQuestionDO;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-04-07 14:35:18
 */
public interface OpenmyQuestionService {
	
	OpenmyQuestionDO get(Long id);
	
	List<OpenmyQuestionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OpenmyQuestionDO openmyQuestion);
	
	int update(OpenmyQuestionDO openmyQuestion);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
