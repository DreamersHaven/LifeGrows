package com.dreamershaven.wechat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dreamershaven.wechat.bean.Space;







public interface SpaceMapper {
	@Select("SELECT * FROM space WHERE id = #{id}")
	Space getSpaceById(Integer id);
 
	@Select("SELECT * FROM space")
	public List<Space> getSpaceList();
 
	@Insert("insert into space(name, address, mapurl,phone,remarks) values(#{name}, #{address}, #{mapurl},#{phone},#{remarks})")
	public int add(Space space);
 
	@Update("UPDATE space SET name = #{space.name} , address = #{space.address} WHERE id = #{id}")
	public int update(@Param("id") Integer id, @Param("space") Space space);
 
	@Delete("DELETE from space where id = #{id} ")
	public int delete(Integer id);

}
