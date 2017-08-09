package com.hfxt.service.impl;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hfxt.domain.vo.UserVo;
import com.hfxt.service.IUserService;

@Service("service.impl.UserServiceImpl")
public class UserServiceImpl extends BaseService implements IUserService {
  	
	private Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);
	
	public UserVo getUserByName(String userName) {
		UserVo user = null;
		try{
			user = userDao.getVoUserByName (userName);
		} catch(Exception e) {
			logger.info("查找用户时发生异常：" + e);
		}
		return user;
	}
	public String getRoleByName(String userName) {
		String role = "";
		try{
			role = userDao.getRoleByUserName (userName);
		} catch(Exception e) {
			logger.info("查找用户角色时发生异常：" + e);
		}
		return role;
	}

	public int addUserByEmail(UserVo user) {
		return userDao.addUserByEmail(user);
	}
	public int addUserByTel(UserVo user) {
		return userDao.addUserByTel(user);
	}
	public int updateUser(UserVo user) {
		return userDao.updateUser(user);
	}

	public UserVo getuserById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.getuserById(id);
	}
	public UserVo getPsdByName(String userName) {
		
		return userDao.getPsdByName (userName);
	}

	public List<UserVo> getAllUser() {
		
		return userDao.getAllUser();
	}
	public void deleteUserById(Integer userId) {
		// TODO Auto-generated method stub
		userDao.deleteUserById(userId);
	}
	public void updateState(UserVo user) {
		
		userDao.updateState(user);
	}
	public Integer updateUserMessage(UserVo user) {
		// TODO Auto-generated method stub
		return userDao.updateUserMessage(user);
	}
	public Integer updatePassword(UserVo user){
		// TODO Auto-generated method stub
		return userDao.updatePassword(user);
	}


}
