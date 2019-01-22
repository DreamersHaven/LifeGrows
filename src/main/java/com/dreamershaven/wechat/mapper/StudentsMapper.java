package com.dreamershaven.wechat.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dreamershaven.wechat.bean.StudentsDO;

/**
 * 
 * @author dongyaxin
 * @email 1992lcg@163.com
 * @date 2018-10-20 16:25:48
 */
@Mapper
public interface StudentsMapper {

	StudentsDO get(Integer id);
	
	List<StudentsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(StudentsDO students);
	
	int update(StudentsDO students);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
