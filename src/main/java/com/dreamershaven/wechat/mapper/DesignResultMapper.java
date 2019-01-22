package com.dreamershaven.wechat.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dreamershaven.wechat.bean.DesignResultDO;

/**
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-01-20 19:59:36
 */
@Mapper
public interface DesignResultMapper {

	DesignResultDO get(Long id);
	
	List<DesignResultDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DesignResultDO designResult);
	
	int update(DesignResultDO designResult);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
