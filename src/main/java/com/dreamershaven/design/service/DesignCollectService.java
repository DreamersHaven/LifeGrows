package com.dreamershaven.design.service;

import java.util.List;
import java.util.Map;

import com.dreamershaven.wechat.bean.DesignCollectDO;
import com.dreamershaven.wechat.bean.DesignUserDO;

/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-04-16 18:07:03
 */
public interface DesignCollectService {
	
	DesignCollectDO get(Long id);
	
	List<DesignCollectDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DesignCollectDO designCollect);
	
	int update(DesignCollectDO designCollect);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	/**
	 * 查找某个用户收藏的其他用户列表
	 * @param userId
	 * @return
	 */
	List<DesignUserDO> getUserInfosByCollect(String id);
}
