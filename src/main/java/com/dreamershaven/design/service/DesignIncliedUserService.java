package com.dreamershaven.design.service;

 

import java.util.List;
import java.util.Map;

import com.dreamershaven.wechat.bean.DesignIncliedUserDO;

/**
 * 
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2019-06-22 20:39:38
 */
public interface DesignIncliedUserService {
	
	DesignIncliedUserDO get(Long id);
	
	List<DesignIncliedUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DesignIncliedUserDO designIncliedUser);
	
	int update(DesignIncliedUserDO designIncliedUser);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	/**
	 * 保存某个用户的自评信息
	 * 按照用户评分等级进行分组保存
	 * 例如：D工作性格中的评分为5级的行为优势：目标导向|纵观全局|良好的组织能力|寻求切实可行的解决方案
	 * 作为一条记录保存
	 * @param designIncliedUserDOs
	 * @return
	 */
	int batchSave(List<DesignIncliedUserDO> designIncliedUsers);
}
