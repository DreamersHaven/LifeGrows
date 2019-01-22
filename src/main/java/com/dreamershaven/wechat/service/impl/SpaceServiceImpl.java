package com.dreamershaven.wechat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamershaven.wechat.bean.Space;
import com.dreamershaven.wechat.mapper.SpaceMapper;
import com.dreamershaven.wechat.service.SpaceService;

@Service
public class SpaceServiceImpl implements SpaceService {
	
	@Autowired
	private SpaceMapper userMapper;

	@Override
	public Space getSpaceById(Integer id) {
		 
		return userMapper.getSpaceById(id);
	}

	@Override
	public List<Space> getSpaceList() {
		 
		return userMapper.getSpaceList();
	}

	@Override
	public int add(Space space) {
		 
		return userMapper.add(space);
	}

	@Override
	public int update(Integer id, Space space) {
		 
		return userMapper.update(id, space);
	}

	@Override
	public int delete(Integer id) {
		 
		return userMapper.delete(id);
	}

	@Override
	/**
	 * 动态构建空间提示信息，用来显示用户输入“空间”关键字
	 */
	public StringBuffer buildWechatInfo() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DreamersHaven 学生空间一表").append("\n\n");
//		buffer.append("1: 传媒空间-临近传媒大学、第二外国语学院、物资学院").append("\n");
//		buffer.append("地址：东领鉴筑1号楼4单元303").append("\n");
//		buffer.append(WeChatContant.CHUANGM_MIP_PIC).append("\n");
//		buffer.append("空间管理员：15600574877").append("\n\n");
//		buffer.append("2： 良乡空间-临近北理工、北中医、北工商、首师范等...").append("\n");
//		buffer.append("地址：良乡大学城旭辉天地12号院3号楼（良乡大学城地铁口向西300米）。").append("\n");
//		buffer.append(WeChatContant.LIANGXIANG_MAP_PIC).append("\n");
//		buffer.append("空间管理员：13176806293").append("\n\n");
		List<Space> spaces =this.getSpaceList();
		if(spaces!=null) {
			for (int i = 0; i < spaces.size(); i++) {
				Space space=spaces.get(i);
				buffer.append(space.getId()+": "+space.getName()+"-"+space.getRemarks()).append("\n");
				buffer.append("地址："+space.getAddress()).append("\n");
				buffer.append("<a href=\""+space.getMapurl()+"\">【点我，打开地图】</a>").append("\n");
				buffer.append("空间管理员:"+space.getPhone()).append("\n\n");
			}
		}
		return buffer;
	}

}
