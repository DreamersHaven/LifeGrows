package com.dreamershaven.wechat.mapper;

 

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dreamershaven.wechat.bean.DesignIncliedDO;

/**
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-06-04 16:53:46
 */
@Mapper
public interface DesignIncliedMapper {

	DesignIncliedDO get(Long id);
	
	List<DesignIncliedDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DesignIncliedDO designInclied);
	
	int update(DesignIncliedDO designInclied);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
