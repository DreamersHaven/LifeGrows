package com.dreamershaven.design.service;

import com.dreamershaven.wechat.bean.DesignTypeDO;

/**
 * DISC测评报告服务接口
 * @author dongyaxin
 *
 */
public interface DiscTypeService {
	/**
	  * 依据DISC坐标值、测评结果、图形类型（M-自我形象，L-对外形象，A-受压形象）
	 *  判断用户DISC测评后的性格类型,并获得该类型的详细测评报告 
	 * @param userId
	 * @return
	 */
	public DesignTypeDO queryUserDISCInfo(String yvalue,String discValue,String type);
	/**
	  * 依据DISC坐标值、测评结果、图形类型（M-自我形象，L-对外形象，A-受压形象）
	 *  判断用户DISC测评后的性格类型
	 * @param userId
	 * @return
	 */
	public String queryUserDISCType(String yvalue,String discValue,String type);
}
