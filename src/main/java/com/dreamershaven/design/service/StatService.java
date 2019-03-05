package com.dreamershaven.design.service;

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
}
