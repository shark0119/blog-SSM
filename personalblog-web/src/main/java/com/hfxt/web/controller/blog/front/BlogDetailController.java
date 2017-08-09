package com.hfxt.web.controller.blog.front;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hfxt.domain.vo.BlogVo;
import com.hfxt.domain.vo.BlogcommentVo;
import com.hfxt.domain.vo.BlogcontentVo;
import com.hfxt.domain.vo.LabelVo;
import com.hfxt.domain.vo.SectionVo;
import com.hfxt.domain.vo.UserVo;
import com.hfxt.service.IJedisBlogLivenessService;
import com.hfxt.service.impl.JedisBlogLivenessServiceImpl;
import com.hfxt.web.controller.BaseController;

import common.utils.NetworkUtil;
import common.vo.Page;



@Controller("front.showBlogController")
// @RequestMapping(IndexController.Location)
public class BlogDetailController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(BlogDetailController.class);
	
	/**
	 * 查看处理的controller
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "front/blog/detailShow")
	public String showBlog(Model model, @RequestParam("blogId") Integer blogId, HttpSession session, HttpServletRequest request,@Param("page") Page page) throws Exception {
		BlogcontentVo blogcontentVo = blogcontentService.findContentById(blogId);
		/*jedisBlogLivenessService.flush(blogId);	*/
		blogcontentVo.setClick(jedisBlogLivenessService.getBlogLivenessCount
						(blogcontentVo.getBlogId(), JedisBlogLivenessServiceImpl.INDEX_CLICK));   
		
		
	    List<BlogcontentVo> blogcontentVos=	blogService.findAllBlog();
	    if(blogcontentVos!=null){
		model.addAttribute("blogcontentVos", blogcontentVos);
	    }
		//获取评论
		/*Map<BlogcommentVo, List<BlogcommentVo>> result = blogcommentService.getReplayCommentByCommentIdMap(blogId);*/
		int count = blogcommentService.getAllCountByBlogId(blogId);
		model.addAttribute("count", count);
		page.setTotalCount(count);
		Map<BlogcommentVo, List<BlogcommentVo>> result=
				blogcommentService.getReplayCommentByCommentIdMap(page.getStartPos(),page.getPageSize(), blogId);
		model.addAttribute("list", result);
		//获取总评论数
		model.addAttribute("page", page);
		model.addAttribute("blogcontentVo", blogcontentVo);
		//对点击量进行记录
		UserVo userVo=(UserVo) session.getAttribute("SYS_USER");
		if (userVo == null){
			userVo = new UserVo();
			userVo.setUserId(-1);
		}
		logger.info("用户的ID是：" + userVo.getUserId());
		logger.info("用户的IP是：" + NetworkUtil.getIpAddress(request));
		jedisBlogLivenessService.blogAddLiveness(
				userVo.getUserId(), 
				NetworkUtil.getIpAddress(request), 
				blogId, IJedisBlogLivenessService.INDEX_CLICK);
		return "blog/front/blogDetailShow";
	}
	
	/**
	 * 按标签查找博客
	 */
	@RequestMapping(method = RequestMethod.GET, value = "front/blog/findBlogByLabel")
	public String mailListBlog(Model model,String labelName) throws Exception {
		List<BlogcontentVo> blogcontentVos=blogcontentService.findBlogContentByLabelName(labelName);
		logger.debug("blogcontentVos="+blogcontentVos);
		if(blogcontentVos!=null && blogcontentVos.size()>0){
			model.addAttribute("blogcontentVos", blogcontentVos);
			return "blog/front/blogIndex";
		}
		return "blog/front/blogIndex";
	}
	
	/**
	 * 按栏目查找博客
	 */
	@RequestMapping(method = RequestMethod.GET, value = "front/blog/findBlogBySection")
	public String findBlogBySection(Model model,String sectionName) throws Exception {
		List<BlogcontentVo> blogcontentVos=blogService.findBlogContentBySectionName(sectionName);
		logger.debug("blogcontentVos="+blogcontentVos);
		
		
		List<SectionVo> sectionVos=sectionService.getAllSections();
		if(sectionVos!=null && sectionVos.size()>0){
			model.addAttribute("sectionVos", sectionVos);
		}
		if(blogcontentVos!=null && blogcontentVos.size()>0){
			model.addAttribute("blogcontentVos", blogcontentVos);
			return "blog/front/blogIndex";
		}
		return "blog/front/blogIndex";
	}
	
}
