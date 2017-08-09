package com.hfxt.web.controller.blog.front;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hfxt.domain.vo.BlogVo;
import com.hfxt.domain.vo.BlogcontentVo;
import com.hfxt.domain.vo.LabelVo;
import com.hfxt.domain.vo.SectionVo;
import com.hfxt.domain.vo.UserVo;
import com.hfxt.service.impl.JedisBlogLivenessServiceImpl;
import com.hfxt.web.controller.BaseController;
import common.model.JsonCrudModel;
import common.vo.Page;
@Controller("front.mainlListBlogController")
public class BlogIndexController extends BaseController {
	private Logger logger = LoggerFactory.getLogger (BlogIndexController.class);
	/**
	 * 跳转首页页面
	 */
	@RequestMapping(method = RequestMethod.GET, value = "front/blog/indexlist")
		public String mailListBlog(Model model,BlogcontentVo blogcontentVo,@Param("page") Page page) throws Exception {
		int count=blogService.findBlogCount();
		page.setTotalCount(count);
		List<BlogcontentVo> blogcontentVos=blogService.findIndexPage(page.getStartPos(), page.getPageSize());
		
		List<SectionVo> sectionVos=sectionService.getAllSections();
		if(sectionVos!=null && sectionVos.size()>0){
			model.addAttribute("sectionVos", sectionVos);
		}
		
		logger.debug("blogcontentVos="+blogcontentVos);
		log.debug("单前总数+"+page.getTotalCount());
		log.debug("当前的页数+"+page.getPageNow());
		model.addAttribute("page", page);
		if(blogcontentVos!=null && blogcontentVos.size()>0){
				model.addAttribute("blogcontentVos", blogcontentVos);
				return "blog/front/blogIndex";
			}
			return "blog/front/blogIndex";
	}

	/**
	 * 跳转投稿页面
	 */
	@RequestMapping(value = "front/blog/add-contributeBlog")
		public String contributeListBlog(Model model,BlogcontentVo blogcontent) throws Exception{
		List<SectionVo> sectionVos=sectionService.getAllSections();
		List<LabelVo> lables=labelService.getLabelsByUserId(1);
		if(lables!=null && lables.size()>0){
			model.addAttribute("lables", lables);
		}
		if(sectionVos!=null && sectionVos.size()>0){
			model.addAttribute("sectionVos", sectionVos);
		}
		return "blog/front/contribute-blog";
	}

	/**
	 * 发布投稿内容
	 */
	@RequestMapping(value="front/blog/addContributeBlog",method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<String> addBlog(BlogcontentVo blogcontent,BlogVo blog,String[] labels,HttpSession session) throws Exception{
		final JsonCrudModel<String> result = new JsonCrudModel<String>();
		UserVo user=(UserVo) session.getAttribute("SYS_USER");
		blog.setDraftContent(1);
		blog.setCheckArticle(3);
		blogcontent.setDraftContent(1);
		blogcontent.setCheckArticle(3);
		if(user!=null){
		blog.setCreatorId(user.getUserId());
		}
		int blogContentId = blogcontentService.addBlogcontent(blogcontent);
		if (blogContentId != -1){
			blog.setBlogContentId(blogContentId);
			int blogId = blogService.addBlog(blog);
			labelService.addLabelForBlog(blogId, user.getUserId(), labels);
		}
		result.setStatus(JsonCrudModel.Status_Success);
		return result;
	}
	/**
	 * 管理投稿文章
	 */
	
	@RequestMapping(value="front/blog/findAllBlogByuserId")
	
	public String findAllBlogByuserId(Model model,BlogcontentVo blogcontent,HttpSession session) throws Exception{
		/*List<BlogcontentVo> blogcontentVos=blogService.findAllBlog();*/
		UserVo user=(UserVo) session.getAttribute("SYS_USER");
		List<BlogcontentVo> blogcontentVos=blogService.findBlogByUserId(user.getUserId());
		
		try{
			
			for (BlogcontentVo content : blogcontentVos){
				content.setComment(jedisBlogLivenessService.getBlogLivenessCount
						(content.getBlogId(), JedisBlogLivenessServiceImpl.INDEX_COMMENT));
				content.setClick(jedisBlogLivenessService.getBlogLivenessCount
						(content.getBlogId(), JedisBlogLivenessServiceImpl.INDEX_CLICK));
				content.setBad(jedisBlogLivenessService.getBlogLivenessCount
						(content.getBlogId(), JedisBlogLivenessServiceImpl.INDEX_BAD));
				content.setGood(jedisBlogLivenessService.getBlogLivenessCount
						(content.getBlogId(), JedisBlogLivenessServiceImpl.INDEX_GOOD));
				content.setNewComment(jedisBlogLivenessService.getBlogNewLivenessCount
						(content.getBlogId(), JedisBlogLivenessServiceImpl.INDEX_COMMENT));
				content.setNewClick(jedisBlogLivenessService.getBlogNewLivenessCount
						(content.getBlogId(), JedisBlogLivenessServiceImpl.INDEX_CLICK));
				content.setNewBad(jedisBlogLivenessService.getBlogNewLivenessCount
						(content.getBlogId(), JedisBlogLivenessServiceImpl.INDEX_BAD));
				content.setNewGood(jedisBlogLivenessService.getBlogNewLivenessCount
						(content.getBlogId(), JedisBlogLivenessServiceImpl.INDEX_GOOD));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		if(blogcontentVos!=null && blogcontentVos.size()>0){
			model.addAttribute("blogcontentVos", blogcontentVos);
		}
		return "blog/front/my-article";
	}
	
}
