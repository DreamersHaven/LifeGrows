package com.dreamershaven.design.service;

import java.util.List;

import com.dreamershaven.design.vo.DiscStatByDiscTypeVO;
import com.dreamershaven.design.vo.DiscStatVO;

/**
 * 统计接口
 * @author dongyaxin
 *
 */
public interface StatService {
	/**
	 * 统计结果查询
	 * @param userId
	 * @return
	 */
	public DiscStatVO stat();
	
	/**
	 * 获得不同类型的数目：例如：D 创建者  30人；
	 * @return
	 */
	public List<DiscStatByDiscTypeVO> countNumsGroupByDiscType();
}
