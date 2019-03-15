package com.dreamershaven.design.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dreamershaven.wechat.bean.DesignUserDO;

public interface UserService {
	/**
	 *  判断用户微信ID是否已经保存
	 * @param userWx
	 * @return
	 */
	public DesignUserDO queryUserWxIsExist(String userWx);
	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	public boolean queryUsernameIsExist(String username);
	/**
	 * 保存用户
	 * @param user
	 */
	public void saveUser(DesignUserDO user);
	
	
	/**
	 * 用户登录，根据用户和密码查询用户
	 * @param user
	 */
	public DesignUserDO queryUserForLogin(String username,String password);
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUserInfo(DesignUserDO user);
	/**
	 * 查询用户信息
	 * @param userId
	 * @return
	 */
	public DesignUserDO queryUserInfo(String userId);
	/**
	 * 依据相应的查询条件获取用户列表信息
	 * @param user
	 * @return
	 */
	public List<DesignUserDO> queryUserList(DesignUserDO user);
	/**
	 * 分页查询用户信息
	 * @return
	 */
	IPage<DesignUserDO> selectPageExt(DesignUserDO user,int page,int pagaSize);
}
