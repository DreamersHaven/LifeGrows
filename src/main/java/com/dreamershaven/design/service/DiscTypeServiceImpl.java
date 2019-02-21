package com.dreamershaven.design.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.design.contant.DiscContant;
import com.dreamershaven.design.vo.DesignDiscVO;
import com.dreamershaven.wechat.bean.DesignTypeDO;
import com.dreamershaven.wechat.mapper.DesignTypeMapper;
@Service
public class DiscTypeServiceImpl implements DiscTypeService {
	private static Logger log = LoggerFactory.getLogger(DiscTypeServiceImpl.class);
	@Autowired
	private DesignTypeMapper designTypeMapper;
	
	/**
	 *   依据传递的参数，将平均值以上的DISC测评结果，封装成DISC坐标对象
	 *  按照y抽坐标由高到底排序，即判断出性格类型。例如：DC，DI，D等
	 *  
	 */
	public DesignTypeDO queryUserDISCInfo(String yvalue, String discValue, String type) {

		String discType=this.queryUserDISCType(yvalue, discValue, type);
		Map<String, Object> query = new HashMap<>(16);
		query.put("discType", discType);
		List<DesignTypeDO> designTypeDOs=designTypeMapper.list(query);
		if(designTypeDOs!=null&&designTypeDOs.size()>0) {
			return designTypeDOs.get(0);
		}else {
			return null;
		}
	}
	
	public String queryUserDISCType(String yvalue, String discValue, String type) {
		String yvalues[]=yvalue.split(",");
		String discValues[]=discValue.split(",");
		String avgValues[]=null;
		String types[]="D,I,S,C".split(",");
		
		if(type!=null) {
			if("M".equals(type)) {
				avgValues=DiscContant.M_AVG.split(",");
			}else if("A".equals(type)) {
				avgValues=DiscContant.A_AVG.split(",");
			}else if("L".equals(type)) {
				avgValues=DiscContant.L_AVG.split(",");
			}
		}else {
			avgValues=DiscContant.M_AVG.split(",");
		}
		
		List<DesignDiscVO> designDiscVOs=new ArrayList<DesignDiscVO>();
		for (int i = 0; i < 4; i++) {
			//只要DISC数值大于平均值，才加入比较数组
			int tempDiscValue;
			int tempAvgValue;
			double tempYValue;
			tempDiscValue=Integer.parseInt(discValues[i]);
			tempAvgValue=Integer.parseInt(avgValues[i]);
			tempYValue=Double.parseDouble(yvalues[i]);
			if(tempDiscValue>tempAvgValue) {
				DesignDiscVO designDiscVO=new DesignDiscVO();
				designDiscVO.setType(types[i]);
				designDiscVO.setyValue(tempYValue);
				designDiscVOs.add(designDiscVO);
			}
		}
		//如果只由一个类型的数据，不用进行排序，直接获得性格特质类型
		StringBuffer discType=new StringBuffer();
		if(designDiscVOs.size()==1) {
			discType.append(designDiscVOs.get(0).getType());
		}else {
			//按照坐标数组中的Y值进行由大到小的排序
			Collections.sort(designDiscVOs, Comparator.comparing(DesignDiscVO::getyValue));
			for (int i = 0; i < designDiscVOs.size(); i++) {
				discType.append(designDiscVOs.get(i).getType());
			}
		}
		
		//如果依据用户测评数据，没有判断出具体类型，返回“errorType”，提示用户测评出错，请重新测试
		if(discType==null||"".equals(discType.toString())) {
			discType.append("errorType");
		}
		
		log.info("DISC测评结果，用户的性格类型为："+discType.toString());
		return discType.toString();
	}

}
