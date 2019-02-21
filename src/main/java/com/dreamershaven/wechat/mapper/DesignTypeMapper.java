package com.dreamershaven.wechat.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dreamershaven.wechat.bean.DesignTypeDO;

/**
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-02-21 09:48:23
 */
@Mapper
public interface DesignTypeMapper {

	DesignTypeDO get(Long id);
	
	List<DesignTypeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DesignTypeDO designType);
	
	int update(DesignTypeDO designType);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
