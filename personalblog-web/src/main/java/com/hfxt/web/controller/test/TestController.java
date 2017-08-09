package com.hfxt.web.controller.test;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hfxt.web.controller.BaseController;
import common.model.JsonCrudModel;


@Controller("front.TestController")
public class TestController extends BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	private static final String Index_Page = "/index";

	@RequestMapping(method = RequestMethod.GET, value = "sendMail")
	public ModelAndView sendMail() {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("aaa");
		try {
			//发送邮件验证
			mailService.sendEmail("595733565@qq.com","c测试", "controller ceshi");
			//短信测试次数已用完
			//mailService.sendEms("15556925243", "测试内容");
			System.out.println("发送成功");
			logger.info("发送成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(Index_Page, map);
	}

	@RequestMapping(value="ajaxTest")
	@ResponseBody
	public JsonCrudModel<Object> ajaxTestCrudModel (){
		System.out.println("ajaxTest");
		JsonCrudModel<Object> model = new JsonCrudModel<Object>();
		model.setStatus(200);
		model.setMessage("OK");
		return model;
	}
	@RequestMapping(value="loggerTest")
	public String loggerTeString (){
		logger.info("abcdTest");
		return "/index";
	}
}
