package com.dreamershaven.design.service;



import java.util.List;
import java.util.Map;

import com.dreamershaven.wechat.bean.DesignOrderDO;

/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-03-26 20:43:22
 */
public interface DesignOrderService {
	
	DesignOrderDO get(Long orderId);
	
	List<DesignOrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DesignOrderDO designOrder);
	
	int update(DesignOrderDO designOrder);
	
	int remove(Long orderId);
	
	int batchRemove(Long[] orderIds);
}
