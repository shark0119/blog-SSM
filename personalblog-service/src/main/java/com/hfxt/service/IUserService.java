package com.hfxt.service;

import java.util.List;

import com.hfxt.domain.vo.UserVo;

public interface IUserService {

  	// 新添加的方法写在这里 /
	int addUserByEmail(UserVo user);
	int addUserByTel(UserVo user);
	int updateUser(UserVo user);
	UserVo getPsdByName(String userName);
	//根据id找到该用户
	public UserVo getuserById(Integer id);
	
	List<UserVo> getAllUser();
	void deleteUserById(Integer userId);
	void updateState(UserVo user);
	Integer updateUserMessage(UserVo user);
	Integer updatePassword(UserVo user);
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	/**
	 * 根据用户名获取用户实体
	 * @param userName 用户名
	 * @return 用户实体
	 */
	UserVo getUserByName(String userName);

	/**
	 * 根据用户名获取角色
	 * @param userName 用户名
	 * @return 角色
	 */
	String getRoleByName(String userName);
}
