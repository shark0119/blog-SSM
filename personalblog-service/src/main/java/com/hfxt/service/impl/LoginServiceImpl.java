package com.hfxt.service.impl;

import org.springframework.stereotype.Service;

import com.hfxt.service.ILoginService;
import common.exception.CustomException;
import common.vo.SessionAdminVo;
import common.vo.SessionUserVo;
@Service("LoginService")
public class LoginServiceImpl extends BaseService implements ILoginService {

	public SessionAdminVo saveSessionAdminVo(String loginName, String loginPass, String host) throws CustomException {
		final SessionAdminVo sessionAdminVo = new SessionAdminVo();

		/*AdminUserSearch search = new AdminUserSearch();
		search.setEqLoginName(loginName);
		search.setRows(1);
		List<AdminUserVo> vos = this.adminUserDao.queryVos_Auto(search);
		AdminUserVo dbVo = (vos == null || vos.isEmpty()) ? null : vos.get(0);

		if (dbVo == null) {
			throw new UnknownAccountException();
		}
		String realPass = PasswordUtils.encryptPassword(loginPass, dbVo.getLoginSalt());
		if (!dbVo.getLoginPass().equals(realPass)) {
			throw new IncorrectCredentialsException();
		}
		if (dbVo.getEnableStatus().intValue() != CustomConstants.Sys_Enabled.Yes) {
			throw new LockedAccountException();
		}

		sessionAdminVo.setId(dbVo.getId());
		sessionAdminVo.setLoginName(dbVo.getLoginName());
		sessionAdminVo.setNickName(dbVo.getNickName());*/
		return sessionAdminVo;
	}

	/**
	 * 处理一般用户登录的请求
	 */
	@SuppressWarnings("unused")
	public SessionUserVo saveSessionUserVo(String loginText, String loginPass,String mobile, String verificatecode, String host) throws CustomException {
		final SessionUserVo sessionUserVo = new SessionUserVo();
		
		return null;
	}

	public SessionUserVo saveSessionUserVo(String loginEmail, String loginPass,
			String host) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}
}
