package com.hfxt.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hfxt.domain.vo.UserVo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public interface IUserDao extends IBaseDao<UserVo,Integer>{
	
	Integer addUserByEmail(UserVo user);
	Integer addUserByTel(UserVo user);
	Integer updateUser(UserVo user);
	UserVo getPsdByName(@Param("userName") String userName);
	//根据用户名返回用户实体
	UserVo getVoUserByName(@Param("userName") String userName);
	//根据用户名来查询用户角色
	String getRoleByUserName(@Param("userName") String userName);
	//根据id找到该用户
	public UserVo getuserById(Integer id);
	
	//查询所有用户信息
	List<UserVo> getAllUser();
	
	void deleteUserById(@Param("userId") Integer userId);
	
	void updateState(UserVo user);
	
	Integer updateUserMessage(UserVo user);
	
	Integer updatePassword(UserVo user);
	
	
}

