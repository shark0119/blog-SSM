package com.hfxt.web.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hfxt.domain.vo.UserVo;
import com.hfxt.web.controller.BaseController;
import common.model.JsonCrudModel;

/**
 * 用户登陆
 * 
 * @author Shark
 *
 */
@Controller("UserLoginController")
public class UserLoginController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	private static String FRONT_LOGIN_PAGE = "login/frontLogin";
	private static String BACK_LOGIN_PAGE = "login/backLogin";

	// 前台和后台登录的跳转
	@RequestMapping(method = RequestMethod.GET, value = "front/login")
	public String frontLogin() {
		return FRONT_LOGIN_PAGE;
	}

	@RequestMapping(method = RequestMethod.GET, value = "back/login")
	public String backLogin() {
		return BACK_LOGIN_PAGE;
	}

	// 前台和后台登录的处理
	@RequestMapping(method = RequestMethod.POST, value = "back/login")
	@ResponseBody
	public JsonCrudModel<Object> backLogin(String username, String password, HttpSession session) {
		JsonCrudModel<Object> result = new JsonCrudModel<Object>();
		if (shiroLoginVerify(username, password) && SecurityUtils.getSubject().hasRole("admin")) {
			UserVo user = userService.getUserByName(username);
			session.setAttribute("SYS_USER", user);
			logger.info("登录成功，用户信息为：" + user);
			result.setStatus(JsonCrudModel.Status_Success);
			result.setMessage("登录成功");
		} else {
			result.setStatus(JsonCrudModel.Status_Error);
			result.setMessage("用户名或密码错误");
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "front/login")
	@ResponseBody
	public JsonCrudModel<Object> frontLogin(String username, String password, HttpSession session) {
		JsonCrudModel<Object> result = new JsonCrudModel<Object>();
		if (shiroLoginVerify(username, password) && SecurityUtils.getSubject().hasRole("user")) {
			UserVo user = userService.getUserByName(username);
			session.setAttribute("SYS_USER", user);
			logger.info("登录成功，用户信息为：" + user);
			result.setStatus(JsonCrudModel.Status_Success);
			result.setMessage("登录成功");
		} else {
			result.setStatus(JsonCrudModel.Status_Error);
			result.setMessage("用户名或密码错误");
		}
		return result;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/loginOut")
	@ResponseBody
	public Map<String, Object> loginOutCrudModel (HttpSession session){
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			Subject subject = SecurityUtils.getSubject();
			subject.logout();
			result.put("success", true);
			result.put("msg", "退出登录成功");
		} catch (Exception e){
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "系统异常");
		}
		return result;
	}
	private boolean shiroLoginVerify(String username, String password) {
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			currentUser.login(token);
			logger.info("验证成功");
			return true;
		} catch (Exception e) {
			logger.info("登录失败：" + e);
			return false;
		}
	}

}
