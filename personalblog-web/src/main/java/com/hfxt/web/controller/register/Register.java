/*package com.hfxt.web.controller.register;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hfxt.domain.vo.RoleVo;
import ch.qos.logback.core.db.dialect.H2Dialect;
import com.hfxt.domain.vo.UserVo;
import com.hfxt.web.controller.BaseController;



@Controller
public class Register extends BaseController{

	private Logger logger = LoggerFactory.getLogger(Register.class);
	
	@RequestMapping("/checkName.action")
	public @ResponseBody Map<String,Object> checkName(HttpServletRequest request,HttpServletResponse response,UserVo user) throws IOException,Exception{
		String emailOrTel = request.getParameter("emailOrTel");
		Map<String,Object> resultMap=new HashMap<String, Object>();
		logger.debug("开始认证：" + emailOrTel);
		UserVo user1=userService.getUserByName(emailOrTel);
		if(null != user1){
			//eamil已存在
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
		
		String theme="欢迎注册！";
		Map<String,String> resultMap=new HashMap<String, String>();
		user.setRoleId(RoleVo.USER);
		int a=(int) (Math.random()*10000);
		session.setAttribute("YZM", a);
	  System.out.println("验证码："+a);
		String content="欢迎来到异清轩博客，您本次的验证码是："+a+","+"请及时处理，如有疑问请致电客服";

		try {
			if(emailOrTel.indexOf("@")>0){ //有@则为邮箱
				user.setAccountEmail(emailOrTel);
				mailService.sendEmail(emailOrTel,theme, content);
				user.setState(UserVo.STATE_UNACTIVE);
			  System.out.println(user);
				userService.addUserByEmail (user);
				resultMap.put("retCode","1");//发送成功
			}else{
				user.setAccountTel(emailOrTel);
				mailService.sendEms(emailOrTel,content);
				user.setState(UserVo.STATE_UNACTIVE);
			  System.out.println(user);
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
	public @ResponseBody Map<String,Object> addUser(HttpServletRequest request,String yzm) throws IOException,Exception{
		
		Map<String,Object> resultMap=new HashMap<String, Object>();
		
		String emailOrTel = (String)request.getSession().getAttribute("UNACTIVE_USER_ACCOUNT");
		String a=(String)(request.getSession().getAttribute("YZM"));
		System.out.println("522222");
		if(a.equals(yzm)){
			System.out.println("222222");
			logger.debug("验证码输入错误");
			resultMap.put("retcod", false);
			resultMap.put("msg", "验证码输入错误");
		}else{
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
		}	
		return resultMap;
	}
}
	*/	

