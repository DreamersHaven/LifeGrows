package com.dreamershaven.wechat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dreamershaven.wechat.bean.DesignUserDO;

/**
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-12-26 18:35:54
 */
@Mapper
public interface DesignUserMapper {

	DesignUserDO get(Long userId);
	
	List<DesignUserDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DesignUserDO designUser);
	
	int update(DesignUserDO designUser);
	
	int remove(Long user_id);
	
	int batchRemove(Long[] userIds);
	
	List<DesignUserDO> selectPageExt(Page<DesignUserDO> page,@Param("user") DesignUserDO user );
	
	List<DesignUserDO> getUserInfos(String discType);
	
	
}
