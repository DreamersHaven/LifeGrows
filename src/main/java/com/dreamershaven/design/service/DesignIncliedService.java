package com.dreamershaven.design.service;

import java.util.List;
import java.util.Map;

import com.dreamershaven.wechat.bean.DesignIncliedDO;

/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-06-04 16:53:46
 */
public interface DesignIncliedService {
	
	DesignIncliedDO get(Long id);
	
	List<DesignIncliedDO> list(Map<String, Object> map);
	
	/**
	 * 依据DISC的测评类型，查询对应的所有行为特征
	 * @param discType
	 * @return
	 */
	List<DesignIncliedDO> queryByDISC(String discType);
	
	int count(Map<String, Object> map);
	
	int save(DesignIncliedDO designInclied);
	
	int update(DesignIncliedDO designInclied);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
