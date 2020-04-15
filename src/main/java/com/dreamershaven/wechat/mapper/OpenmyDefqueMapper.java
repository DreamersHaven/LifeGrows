package com.dreamershaven.wechat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dreamershaven.wechat.bean.OpenmyDefqueDO;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-04-07 14:35:10
 */
@Mapper
public interface OpenmyDefqueMapper {

	OpenmyDefqueDO get(Integer numOrder);
	
	List<OpenmyDefqueDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(OpenmyDefqueDO openmyDefque);
	
	int update(OpenmyDefqueDO openmyDefque);
	
	int remove(Integer num_order);
	
	int batchRemove(Integer[] numOrders);
}
