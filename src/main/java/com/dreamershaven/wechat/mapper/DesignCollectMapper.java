package com.dreamershaven.wechat.mapper;

 

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dreamershaven.wechat.bean.DesignCollectDO;
import com.dreamershaven.wechat.bean.DesignUserDO;

/**
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-04-16 18:07:03
 */
@Mapper
public interface DesignCollectMapper {

	DesignCollectDO get(Long id);
	
	List<DesignCollectDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DesignCollectDO designCollect);
	
	int update(DesignCollectDO designCollect);
	
	int remove(String id);
	
	int batchRemove(Long[] ids);
	
	List<DesignUserDO> getUserInfosByCollect(Long id);
}
