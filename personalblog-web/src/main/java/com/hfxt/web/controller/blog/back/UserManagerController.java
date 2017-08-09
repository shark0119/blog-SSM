package com.hfxt.web.controller.blog.back;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hfxt.domain.vo.UserVo;
import com.hfxt.web.controller.BaseController;


@Controller
public class UserManagerController extends BaseController{

	@RequestMapping(value="back/userManager/list",method=RequestMethod.GET)
	
	public String getAllUser(Model model) throws Exception{
		List<UserVo> users=userService.getAllUser();
		if(users!=null && users.size()>0){
			model.addAttribute("users", users);
		}
		return "blog/back/manager-user";
	}
	
	@RequestMapping(value="back/userManager/delete",method=RequestMethod.POST)
	public String deleteUserById(Model model,Integer userId) throws Exception{
		userService.deleteUserById(userId);
		return "redirect:list";
	}
	
	@RequestMapping(value="back/userManager/updateState",method=RequestMethod.GET)
	public String updateState(Model model,Integer userId,Integer state) throws Exception{
		UserVo user=new UserVo();
		if(state==1){
			user.setState(2);
		}else{
			user.setState(1);
		}
		user.setUserId(userId);
		userService.updateState(user);
		return "redirect:list";
	}
	
}

