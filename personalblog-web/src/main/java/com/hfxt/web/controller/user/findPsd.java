package com.hfxt.web.controller.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hfxt.domain.vo.UserVo;
import com.hfxt.web.controller.BaseController;

@Controller
public class findPsd extends BaseController {

	private Logger logger = LoggerFactory.getLogger(findPsd.class);
	
	@RequestMapping("/sendCode.action")
	public @ResponseBody Map<String,String> sendCode(HttpServletRequest request,String emailOrTel,UserVo user,HttpSession session){
		log.debug("进入方法，开始发送验证");
		String theme="欢迎来到易军博客";
		Map<String,String> resultMap=new HashMap<String, String>();
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
				resultMap.put("retCode","1");//发送成功
			}else{
				user.setAccountTel(emailOrTel);
				mailService.sendEms(emailOrTel,content);
				resultMap.put("retCode","1");//发送成功
				}
		}catch (Exception e) {
			e.printStackTrace();
			resultMap.put("retCode","2");//发送失败
		}
		return resultMap;
	}
	
	@RequestMapping("/findPassword.action")
	public @ResponseBody Map<String,Object> findPassword(HttpServletRequest request,String emailOrTel,int yzm) throws IOException,Exception{
		Map<String,Object> resultMap=new HashMap<String, Object>();
		int  code=(Integer) request.getSession().getAttribute("code");
		log.debug("进入找密码");
		log.debug("当前的用户名：+"+emailOrTel);
		log.debug("当前的验证码+"+yzm);
		log.debug("当前session中的验证吗+"+code);
		if(code==yzm){
			String password=userService.getPsdByName(emailOrTel).getPassword();
			log.debug("当前的密码"+password);
			if(password!=null){
				resultMap.put("retCode",true);//成功
				resultMap.put("password",password);
				return resultMap;
			}else{
				resultMap.put("retCode", false);//失败
			}
		}else{
			System.out.println("222222");
			logger.debug("验证码输入错误");
			resultMap.put("retcod", false);
			resultMap.put("msg", "验证码输入错误");
		}	
		return resultMap;
	}
	
	
}
