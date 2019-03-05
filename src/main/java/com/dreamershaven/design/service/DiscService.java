package com.dreamershaven.design.service;

import java.util.List;

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
	
	/**
	 * 查询用户DISC结果信息
	 * @param userId
	 * @return
	 */
	public DesignResultDO queryUserDISCInfo(String userId);

	/**
	 * 查询用户所有DISC结果信息列表
	 * @param userId
	 * @return
	 */
	public List<DesignResultDO> queryUserDISCInfos(String userId);
	/**
	 * 删除某条历史测试报告
	 * @param id
	 * @return
	 */
	public boolean delDiscHistoryResult(String id);
	
	
	
}
