package com.dreamershaven.design.service;

import com.dreamershaven.wechat.bean.DesignResultDO;

/**
 * DISC服务接口
 * @author dongyaxin
 *
 */
public interface DiscService {
	/**
	 * 保存DISC测评结果
	 * @param designResultDO
	 */
	public void saveResult(DesignResultDO designResultDO);
}
