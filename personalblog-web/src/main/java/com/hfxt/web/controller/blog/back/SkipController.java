package com.hfxt.web.controller.blog.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hfxt.domain.vo.BlogcontentVo;
import com.hfxt.domain.vo.LabelVo;
import com.hfxt.domain.vo.SectionVo;
import com.hfxt.domain.vo.UserVo;
import com.hfxt.web.controller.BaseController;
@Controller("front.AddListController")

public class SkipController extends BaseController {
	/*private static final String Index_Page = "blog/back/add-blog";*/
	/*private static final String Update_Page = "blog/back/update-blog";*/
	private static final String AllBlog_Page = "blog/back/all-blog";
	

	
	/**
	 * 跳转添加页面
	 */
	@RequestMapping(value = "back/blog/add-blog")
	public String addListBlog(Model model,BlogcontentVo blogcontent,HttpSession session) throws Exception{
		List<SectionVo> sectionVos=sectionService.getAllSections();
		UserVo user=(UserVo) session.getAttribute("SYS_USER");
		List<LabelVo> lables=labelService.getLabelsByUserId(user.getUserId());
		if(lables!=null && lables.size()>0){
			model.addAttribute("lables", lables);
		}
		if(sectionVos!=null && sectionVos.size()>0){
			model.addAttribute("sectionVos", sectionVos);
		}
		return "blog/back/add-blog";
	}
	
	
	/**
	 * 跳转修改页面
	 */
	@RequestMapping(value = "back/blog/update-blog")
	public String updateListBlog(Model model,HttpSession session) throws Exception {
		List<SectionVo> sectionVos=sectionService.getAllSections();
		UserVo user=(UserVo) session.getAttribute("SYS_USER");
		List<LabelVo> lables=labelService.getLabelsByUserId(user.getUserId());
		if(lables!=null && lables.size()>0){
			model.addAttribute("lables", lables);
		}
		if(sectionVos!=null && sectionVos.size()>0){
			model.addAttribute("sectionVos", sectionVos);
		}
		return "blog/back/update-blog";
	}
	
	/**
	 * 跳转后端首页页面
	 */
	@RequestMapping(method = RequestMethod.GET, value = "back/blog/all-blog")
	public ModelAndView BlogListBlog() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		return new ModelAndView(AllBlog_Page,map);
	}
}
