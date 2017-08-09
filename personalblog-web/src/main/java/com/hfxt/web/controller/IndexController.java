package com.hfxt.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller("front.IndexController")
//@RequestMapping(IndexController.Location)
public class IndexController extends BaseController {
	//public static final String Location = "/";
	// 登录页面
	private static final String Index_Page = "/index";
	
	/**
	 * 跳转首页页面
	 */
	@RequestMapping(method = RequestMethod.GET, value = "index")
	public ModelAndView login() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		/* SessionUserVo sessionUserVo = this.getSessionUser();
		 UserRoleRefVo vo;
		 if(sessionUserVo!=null){
			 UserRoleRefSearch userRoleRefSearch = new UserRoleRefSearch();
			 userRoleRefSearch.setEqUserId(sessionUserVo.getId());
			vo = userRoleRefService.queryVo_Auto(userRoleRefSearch);
			map.put("role",vo.getRoleId());
		 }
		 map.put("user", sessionUserVo);
		 GoodsSearch search = new GoodsSearch();
		 search.setEqGoodsState(3);
		 search.setRows(10);
		 List<GoodsVo> goodsList = goodsService.queryVos_Auto(search);
		 map.put("goodsList", goodsList);*/
		System.out.println("aaa");
		return new ModelAndView(Index_Page,map);
	}

}
