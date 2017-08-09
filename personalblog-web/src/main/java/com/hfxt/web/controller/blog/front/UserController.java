package com.hfxt.web.controller.blog.front;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hfxt.domain.vo.UserVo;
import com.hfxt.web.controller.BaseController;


@Controller
public class UserController extends BaseController{

	
	@RequestMapping(value="front/user/findUser",method=RequestMethod.GET)
	public String findUser(Model model,Integer userId,Integer page) throws Exception{
		if(page==1){
			UserVo user=userService.getuserById(userId);
			System.out.println(user);
			model.addAttribute("user", user);
			return "blog/front/userMessage";
			
		}else if(page==2){
			UserVo user=userService.getuserById(userId);
			System.out.println(user);
			model.addAttribute("user", user);
			return "blog/front/updateUserMessage";
		}else{
			UserVo user=userService.getuserById(userId);
			System.out.println(user);
			model.addAttribute("user", user);
			return "blog/front/updatePassword";
		}
	}
@RequestMapping(value="front/user/updateUserMessage",method=RequestMethod.POST)
@ResponseBody
	public String updateUserMessage(Model model,HttpServletRequest req) throws Exception{
	Integer id=Integer.parseInt(req.getParameter("userId"));
	System.out.println(id);
		UserVo user=userService.getuserById(id);
		String nickName=req.getParameter("nickName");
		String accountEmail=req.getParameter("email");
		String accountTel=req.getParameter("tel");
		System.out.println(nickName+"--");
		user.setAccountEmail(accountEmail);
		user.setAccountTel(accountTel);
		user.setNickName(nickName);
		
		int row=userService.updateUserMessage(user);
		System.out.println("row值为多少"+row);
		if(row>0){
			 return "success";
		}else{
			 return "error";
		}
	}
@RequestMapping(value="front/user/updatePassword",method=RequestMethod.POST)
@ResponseBody
public String updatePassword(Model model,HttpServletRequest req) throws Exception{
	Integer id=Integer.parseInt(req.getParameter("id"));
	String password=req.getParameter("password");
	UserVo user=new UserVo();
	user.setUserId(id);
	user.setPassword(password);
	
	 int row=userService.updatePassword(user);
	 if(row>0){
		 return "success";
	 }else{
		 return "error";
	 }
}
}

