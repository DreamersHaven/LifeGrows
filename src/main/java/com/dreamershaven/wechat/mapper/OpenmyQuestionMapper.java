package com.dreamershaven.wechat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dreamershaven.wechat.bean.OpenmyQuestionDO;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-04-07 14:35:18
 */
@Mapper
public interface OpenmyQuestionMapper {

	OpenmyQuestionDO get(Long id);
	
	List<OpenmyQuestionDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(OpenmyQuestionDO openmyQuestion);
	
	int update(OpenmyQuestionDO openmyQuestion);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
