package com.hfxt.service;

import common.exception.CustomException;
import common.vo.SessionAdminVo;
import common.vo.SessionUserVo;

public interface ILoginService {

	/**
	 * 处理管理员登录的请求
	 */
	SessionAdminVo saveSessionAdminVo(String loginName, String loginPass, String host) throws CustomException;

	/**
	 * 处理一般用户登录的请求
	 */
	SessionUserVo saveSessionUserVo(String loginEmail, String loginPass, String host) throws CustomException;
}
