package com.dreamershaven.wechat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dreamershaven.wechat.bean.OpenmyAnswerDO;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-04-07 14:35:00
 */
@Mapper
public interface OpenmyAnswerMapper {

	OpenmyAnswerDO get(Long id);
	
	List<OpenmyAnswerDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(OpenmyAnswerDO openmyAnswer);
	
	int update(OpenmyAnswerDO openmyAnswer);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int maxGroupId(Map<String,Object> map);
}
