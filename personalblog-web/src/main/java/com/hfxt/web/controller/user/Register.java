package com.hfxt.web.controller.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hfxt.domain.vo.RoleVo;
import com.hfxt.domain.vo.UserVo;
import com.hfxt.web.controller.BaseController;



@Controller
public class Register extends BaseController{

	private Logger logger = LoggerFactory.getLogger(Register.class);
	
	@RequestMapping("/checkName.action")
	public @ResponseBody Map<String,Object> checkName(HttpServletRequest request,HttpServletResponse response,String  emailOrTel) throws IOException,Exception{
		
		/*System.out.println("checkName");
		String emailOrTel = request.getParameter("emailOrTel");*/
		log.debug("进入方法当前页面的用户名是"+emailOrTel);
		Map<String,Object> resultMap=new HashMap<String, Object>();
		logger.debug("开始认证：" + emailOrTel);
		UserVo user1=userService.getUserByName(emailOrTel);
		if(null != user1){
			logger.debug("用户名已注册");
			resultMap.put("retcode", false);
			resultMap.put("msg", "用户名已被占用");
			return resultMap;
		}else {
			logger.debug("用户名未注册");
			resultMap.put("retcode", true);
			resultMap.put("msg", "用户名可用");
		}
		return resultMap;	
	}
	
	@RequestMapping("/sendYZM.action")
	public @ResponseBody Map<String,String> sendYZM(HttpServletRequest request,String emailOrTel,String password,UserVo user,HttpSession session){
		log.debug("进入方法，开始发送验证");
		String theme="欢迎来到易军博客";
		Map<String,String> resultMap=new HashMap<String, String>();
		user.setRoleId(RoleVo.USER);
		int code=(int) (Math.random()*10000);
		while(code<1000){
			code=(int) (Math.random()*10000);
		}
		request.getSession().setAttribute("code", code);
	  System.out.println("验证码："+code);
		String content="尊敬的用户，您本次的验证码是："+code+","+"请及时处理";
		

		try {
			if(emailOrTel.indexOf("@")>0){ //有@则为邮箱
				user.setAccountEmail(emailOrTel);
				mailService.sendEmail(emailOrTel,theme, content);
				user.setState(UserVo.STATE_UNACTIVE);
				userService.addUserByEmail (user);
				resultMap.put("retCode","1");//发送成功
			}else{
				user.setAccountTel(emailOrTel);
				mailService.sendEms(emailOrTel,content);
				user.setState(UserVo.STATE_UNACTIVE);
				userService.addUserByTel (user);
				resultMap.put("retCode","1");//发送成功
				}
			request.getSession().setAttribute ("UNACTIVE_USER_ACCOUNT", emailOrTel);
		}catch (Exception e) {
			e.printStackTrace();
			resultMap.put("retCode","2");//发送失败
		}
		return resultMap;
	}
	
	@RequestMapping("/addUser.action")
	public @ResponseBody Map<String,Object> addUser(HttpServletRequest request,int yzm) throws IOException,Exception{
		
		System.out.println("addUser");
		Map<String,Object> resultMap=new HashMap<String, Object>();
		
		String emailOrTel = (String)request.getSession().getAttribute("UNACTIVE_USER_ACCOUNT");
		//String a= ((Integer) request.getSession().getAttribute("YZM")).toString();
		int newCode=(Integer) request.getSession().getAttribute("code");
		System.out.println("session中储存的"+newCode);
		System.out.println("接收的验证码："+yzm);
		System.out.println(yzm==newCode);
		if(yzm==newCode){
			log.debug("当前验证码是：+"+newCode);
			UserVo user=userService.getUserByName(emailOrTel);
			user.setState(UserVo.STATE_ACTIVE);
			System.out.println(user);
			int result=userService.updateUser(user);
			if(result>0){
				resultMap.put("retCode",true);//成功
				return resultMap;
			}else{
				resultMap.put("retCode", false);//失败
			}
		}else{
			logger.debug("验证码输入错误");
			resultMap.put("retCode", false);
			resultMap.put("msg", "验证码输入错误");
		}	
		return resultMap;
	}
}
		

