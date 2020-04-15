package com.dreamershaven.wechat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dreamershaven.wechat.bean.DesignIncliedUserDO;

/**
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-06-22 20:39:38
 */
@Mapper
public interface DesignIncliedUserMapper {

	DesignIncliedUserDO get(Long id);
	
	List<DesignIncliedUserDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DesignIncliedUserDO designIncliedUser);
	
	int update(DesignIncliedUserDO designIncliedUser);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int batchSave(List<DesignIncliedUserDO> designIncliedUsers);
}
