package com.hfxt.web.controller.blog.back;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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


@Controller("front.BlogController")
public class BlogController extends BaseController{

	
	/**
	 * 发布博客内容
	 * draftContent： 其中1代表发布博客，2代表草稿箱博客, checkArticle:1代表文章审核通过，2代表审核不通过
	 */
	@RequestMapping(value="back/blog/addBlog",method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<String> addBlog(BlogcontentVo blogcontent,BlogVo blog,String[] labels,HttpSession session) throws Exception{
		final JsonCrudModel<String> result = new JsonCrudModel<String>();
		System.out.println("blogcontent是+="+blogcontent.toString());
		UserVo user=(UserVo) session.getAttribute("SYS_USER");
		blog.setDraftContent(1);
		blogcontent.setDraftContent(1);
		blog.setCheckArticle(1);
		blogcontent.setCheckArticle(1);
		System.out.println("blogcontent是+="+blogcontent.toString());
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
	 * 保存草稿箱博客内容
	 */
	@RequestMapping(value="back/blog/addDratfBlog",method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<String> addDraftBlog(BlogcontentVo blogcontent,BlogVo blog,String[] labels,HttpSession session) throws Exception{
		final JsonCrudModel<String> result = new JsonCrudModel<String>();
		UserVo user=(UserVo) session.getAttribute("SYS_USER");
		blog.setDraftContent(2);
		blog.setCheckArticle(1);
		blogcontent.setDraftContent(2);
		blogcontent.setCheckArticle(1);
		if(user!=null){
			blog.setCreatorId(user.getUserId());
			}
		int blogContentId = blogcontentService.addBlogcontent(blogcontent);
		if (blogContentId != -1){
			blog.setBlogContentId(blogContentId);
			int blogId = blogService.addBlog(blog);
			labelService.addLabelForBlog(blogId, user.getUserId(), labels);
			result.setStatus(JsonCrudModel.Status_Success);
		}else{
		result.setStatus(JsonCrudModel.Status_Error);
		}
		return result;
	}
	/**
	 * 查出所有博客并显示
	 */
	@RequestMapping(value="back/blog/findAllBlog")
	
	public String findAllBlog(Model model,BlogcontentVo blogcontent,HttpSession session,@Param("page") Page page) throws Exception{
		int count=blogService.findBlogCount();
		page.setTotalCount(count);
		List<BlogcontentVo> blogcontentVos=blogService.findIndexPage(page.getStartPos(), page.getPageSize());
	/*	logger.debug("blogcontentVos="+blogcontentVos);*/
		log.debug("单前总数+"+page.getTotalCount());
		log.debug("当前的页数+"+page.getPageNow());
		model.addAttribute("page", page);
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
		return "blog/back/all-blog";
	}
	
	
	/**
	 * 查出所有草稿箱博客并显示
	 */
	@RequestMapping(value="back/blog/findAllDraftBlog")
	
	public String findAllDraftBlog(Model model,BlogcontentVo blogcontent,HttpSession session) throws Exception{
		/*UserVo user=(UserVo) session.getAttribute("SYS_USER");*/
		List<BlogcontentVo> blogcontentVos=blogService.findAllDraftBlog();
		if(blogcontentVos!=null && blogcontentVos.size()>0){
			model.addAttribute("blogcontentVos", blogcontentVos);
		}
		return "blog/back/all-blog";
	}
	
	/**
	 * 删除单条博客
	 */
	@RequestMapping(value="back/blog/deleteBlog",method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<String> deleteBlogById(@RequestParam("blogcontentId") Integer id) throws Exception{
		final JsonCrudModel<String> result = new JsonCrudModel<String>();
	    int result1=blogService.deleteBlog(id);
		if(result1>0){
			result.setStatus(JsonCrudModel.Status_Success);
		}else{
		result.setStatus(JsonCrudModel.Status_Error);
		}
		return result;
	}
	
	
	
	/**批量删除
	 * @return
	 */
	@RequestMapping(value="back/blog/allDelete",method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<BlogVo> allDelete(String blogIds){
		final JsonCrudModel<BlogVo> result = new JsonCrudModel<BlogVo>();
		//对传过来的数组进行解析
		String [] blogids=blogIds.split(",");
		//log.debug(""+blogids.length);
		log.debug("当前数组的长度+"+blogids.length);
		//解析数组
		for(int i=0;i<blogids.length;i++){
			log.debug("当前博客的"+blogids[i]);
			
			int blogid=Integer.parseInt(blogids[i]);
			//找到当前的博客
			BlogVo  blogVo=blogService.findBlogById(blogid);
			//删除内容
			log.debug("开始删除博客内容");
			int count=blogService.deleteBlog(blogVo.getBlogContentId());
			//博客本身
			
			if(count>0){
				log.debug("成功count当前的状态"+count);
				//删除成功
				result.setStatus(JsonCrudModel.Status_Success);
			}else{
				//删除失败
				result.setStatus(JsonCrudModel.Status_Error);
				log.debug("失败count当前的状态"+count);
			}
		}
		return result;
	}
	
	/**
	 * 更新博客内容
	 */
	@RequestMapping(value="back/blog/updateBlog",method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<String> updateBlogById(@RequestParam("blogcontentId") Integer id,BlogcontentVo blogcontent,BlogVo blog) throws Exception{
		final JsonCrudModel<String> result = new JsonCrudModel<String>();
		System.out.println("是否更新");
		blog.setBlogContentId(id);
		blogcontent.setBlogContentId(id);
	    int result1=blogService.updateBlog(blog);
	    int result2 = blogcontentService.updateBlogContent(blogcontent);
		if(result2>0||result1>0){
			result.setStatus(JsonCrudModel.Status_Success);
		}else{
		result.setStatus(JsonCrudModel.Status_Error);
		}
		return result;
	}
	
	/**
	 * 查找需要更新的博客内容
	 */
	@RequestMapping(method = RequestMethod.GET, value = "back/blog/updateContentShow")
	public String showBlog(Model model, @RequestParam("blogcontentId") Integer blogcontentId, HttpSession session, HttpServletRequest request) throws Exception {
		System.out.println("blogId===" + blogcontentId);
		BlogcontentVo blogcontentVo = blogcontentService.findContentByBctId(blogcontentId);
		UserVo user=(UserVo) session.getAttribute("SYS_USER");
		
		List<SectionVo> sectionVos=sectionService.getAllSections();
		List<LabelVo> lables=labelService.getLabelsByUserId(user.getUserId());
		if(lables!=null && lables.size()>0){
			model.addAttribute("lables", lables);
		}
		
		if(sectionVos!=null && sectionVos.size()>0){
			model.addAttribute("sectionVos", sectionVos);
		}
		model.addAttribute("blogcontentVo", blogcontentVo);
		return "blog/back/update-blog";
	}
	
	/**
	 * 查出所有投稿文章并显示
	 */
	@RequestMapping(value="back/blog/findAllCheckArticle")
	
	public String findAllCheckArticle(Model model,BlogcontentVo blogcontent,@Param("page") Page page) throws Exception{
		/*List<BlogcontentVo> blogcontentVos=blogService.findAllNotCheckBlog();*/
		
		int count=blogService.findBlogCountNotCheckOrNotpass();
		page.setTotalCount(count);
		List<BlogcontentVo> blogcontentVos=blogService.findAllNotCheckBlogPage(page.getStartPos(), page.getPageSize());
	/*	logger.debug("blogcontentVos="+blogcontentVos);*/
		log.debug("单前总数+"+page.getTotalCount());
		log.debug("当前的页数+"+page.getPageNow());
		model.addAttribute("page", page);
		if(blogcontentVos!=null && blogcontentVos.size()>0){
			model.addAttribute("blogcontentVos", blogcontentVos);
		}
		return "blog/back/check-article";
	}
	
	/**
	 * 查看审核文章 并进行审核
	 */
	@RequestMapping(value = "back/blog/checkBlogDetail" ,method=RequestMethod.GET )
	public String deleteCommentinfo(Model model,Integer blogId) throws Exception{
		
		BlogcontentVo blogcontentVo = blogcontentService.findContentById(blogId);
		   model.addAttribute("blogcontentVo", blogcontentVo);
		
	       return "blog/back/check-Detailarticle";
	}
	/**
	 * 审核通过
	 */
	@RequestMapping(value = "back/blog/checkPass" ,method=RequestMethod.GET )
	public String checkPass(Model model,Integer blogId) throws Exception{
		
		
		BlogcontentVo blogcontentVo = blogcontentService.findContentById(blogId);
	    BlogVo blogVo=blogService.findBlogById(blogId);
		blogcontentVo.setCheckArticle(1);
		blogVo.setCheckArticle(1);
		blogcontentService.updateBlogContent(blogcontentVo);
		blogService.updateBlog(blogVo);
		
		UserVo user=userService.getuserById(blogVo.getCreatorId());
		System.out.println("此邮箱是"+user.getAccountEmail());
		mailService.sendEmail(user.getAccountEmail(), "您的投稿来回复啦", "恭喜你，你的投稿已通过审核");
	    return "redirect:findAllCheckArticle";
	}
	
	/**
	 * 审核不通过
	 */
	@RequestMapping(value = "back/blog/checkNotPass" ,method=RequestMethod.GET )
	public String checkNotPass(Model model,Integer blogId) throws Exception{
		
		BlogcontentVo blogcontentVo = blogcontentService.findContentById(blogId);
	    BlogVo blogVo=blogService.findBlogById(blogId);
		blogcontentVo.setCheckArticle(2);
		blogVo.setCheckArticle(2);
		blogcontentService.updateBlogContent(blogcontentVo);
		blogService.updateBlog(blogVo);
		 
		UserVo user=userService.getuserById(blogVo.getCreatorId());
		System.out.println("此邮箱是"+user.getAccountEmail());
		mailService.sendEmail(user.getAccountEmail(), "您的投稿来回复啦", "对不起，你的投稿未通过审核");
	    return "redirect:findAllCheckArticle";
	}
}

