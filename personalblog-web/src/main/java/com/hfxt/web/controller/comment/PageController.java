package com.hfxt.web.controller.comment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hfxt.domain.vo.BlogcommentVo;
import com.hfxt.domain.vo.BlogcontentVo;
import com.hfxt.domain.vo.NoticeVo;
import com.hfxt.domain.vo.UserVo;
import com.hfxt.service.IJedisBlogLivenessService;
import com.hfxt.service.impl.JedisBlogLivenessServiceImpl;
import com.hfxt.web.controller.BaseController;
import common.model.JsonCrudModel;
import common.utils.NetworkUtil;
import common.vo.Page;




@Controller("BlogComment.PageController")
@RequestMapping(PageController.Location)
public class PageController extends BaseController implements Serializable {

	private IJedisBlogLivenessService jedisService;
	public PageController (){
		jedisService = new JedisBlogLivenessServiceImpl();
	}
	private static final long serialVersionUID = 6219876708802336943L;

	public static final String Location = "/comment";
	//404页面
	private static final String Page_404 = "../../resources/errors/404";

	private static final String LISt_PAGE = "/blog/front/blogDetailShow";
	
	private static final String LISt_PAGE2 = "/blog/back/deleteblog-DetailShow";
	
	/**
	 * 查看处理的controller
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "list" ,method=RequestMethod.GET )
	public String getallreplyComment(Model model,Integer id,@Param("page") Page page ) throws Exception{
		//创建一个map接收
		/*Map<BlogcommentVo, List<BlogcommentVo>>result=
				blogcommentService.getReplayCommentByCommentIdMap(1);*/
		//获取评论个数
		Integer count =blogcommentService.getAllCountByBlogId(1);
		//log.debug("个数"+count);
		//log.debug("进入");
		model.addAttribute("count", count);
		page.setTotalCount(count);
		Map<BlogcommentVo, List<BlogcommentVo>> result=
				blogcommentService.getReplayCommentByCommentIdMap(page.getStartPos(),page.getPageSize(), 1);
		model.addAttribute("list", result);
		log.debug("单前总数+"+page.getTotalCount());
		log.debug("当前的页数+"+page.getPageNow());
		model.addAttribute("page", page);
		
		return LISt_PAGE;
	}
	/**
	 * 增加一条主评论
	 * @param model
	 * @param blogcommentVo
	 * @return
	 */
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<BlogcommentVo> addComment( BlogcommentVo blogcommentVo,HttpServletRequest request){
		log.debug("增加主评论 的博客ID+"+blogcommentVo.getBlogId());
		
		//获取当前的登录的用户
		final JsonCrudModel<BlogcommentVo> result = new JsonCrudModel<BlogcommentVo>();
		UserVo userVo=(UserVo) request.getSession().getAttribute("SYS_USER");
		
		if(userVo==null || userVo.getState()==2){
			//没有登录或者被禁言
			result.setMessage("未知用户");
			return result;
		}
		log.debug("当前登录用户id {}", userVo.getUserId());
		blogcommentVo.setCreatorId(userVo.getUserId());
		if((userVo.getAccountEmail().equals("") && blogcommentVo.getDynamicNotice()==1)
				|| userVo.getState()==0){
			//未认证，或者没有邮箱
			result.setMessage("未知邮箱");
			return result;
		}
		//执行新增操作
		try {
			Integer newID=0;
			//测试当前最大的Id
			Integer maxId=blogcommentService.getCommentMaxId();
			log.debug("当前最大的id+"+maxId);
			//判断一下
			if(maxId==null){
				 newID=1;
			}else{
				newID=maxId+1;
			}
			//赋值id
			blogcommentVo.setCommentId(newID);
			int i=blogcommentService.addComment(blogcommentVo);
			if(i>0){
				//成功
				result.setStatus(JsonCrudModel.Status_Success);
				jedisService.blogAddLiveness(userVo.getUserId(), NetworkUtil.getIpAddress(request), blogcommentVo.getBlogId(), JedisBlogLivenessServiceImpl.INDEX_COMMENT);
				log.debug("当前登录用户的邮箱{} ",userVo.getAccountEmail());
				//发送消息(维护)
				NoticeVo notice=new NoticeVo();
				notice.setActorId(userVo.getUserId());
				notice.setActorName(userVo.getNickName());
				notice.setBlogId(blogcommentVo.getBlogId());
				notice.setBlogTitle(blogcontentService.findContentById(blogcommentVo.getBlogId()).getTitle());
				notice.setOperateType(NoticeVo.OPERATE_COMMENT);
				notice.setState(NoticeVo.STATE_UNREAD);
				notice.setComment(blogcommentVo.getCommentContent());
				notice.setCommentId(newID);
				notice.setCreateTime(new Date());
				noticeService.addNotice(notice, blogService.findBlogById(blogcommentVo.getBlogId()).getCreatorId());
			}else if(i==0) {
				//失败
				result.setStatus(JsonCrudModel.Status_Error);
			}
			//log.debug(""+result.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
	/**回复一条评论
	 * @param blogcommentVo
	 * @return
	 */
	@RequestMapping(value="addreply",method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<BlogcommentVo> addreplyComment(BlogcommentVo blogcommentVo,Integer blogId,HttpServletRequest request){
		final JsonCrudModel<BlogcommentVo> result = new JsonCrudModel<BlogcommentVo>();
		//获取当前登录的人
		UserVo userVo=(UserVo) request.getSession().getAttribute("SYS_USER");
		if(userVo==null || userVo.getState()==2){
			//未登录或者被禁言
			result.setMessage("未知用户");
			return result;
		}
		log.debug("当前登录用户id {}", userVo.getUserId());
		blogcommentVo.setCreatorId(userVo.getUserId());
		
		if((userVo.getAccountEmail().equals("") && blogcommentVo.getDynamicNotice()==1)
				|| userVo.getState()==0){
			//没有邮箱或者邮箱为认证
			result.setMessage("未知邮箱");
			return result;
		}
		//知道到当前回复的评论的主人
		int commentId=blogcommentVo.getRefCommentId();
		UserVo user=new UserVo();
		//找到当前需要回复的评论是否需要通知
		BlogcommentVo comment=new BlogcommentVo();
		try {
			Integer newID=0;
			//测试当前最大的Id
			Integer maxId=blogcommentService.getCommentMaxId();
			log.debug("当前最大的id+"+maxId);
			//判断一下
			if(maxId==null){
				 newID=1;
			}else{
				newID=maxId+1;
			}
			
			//赋值id
			blogcommentVo.setCommentId(newID);
			int i=blogcommentService.addReplyComment(blogcommentVo);
			if(i>0){
				//成功
				result.setStatus(JsonCrudModel.Status_Success);
				//维护数据
				jedisService.blogAddLiveness(userVo.getUserId(), NetworkUtil.getIpAddress(request), blogId, JedisBlogLivenessServiceImpl.INDEX_COMMENT);
				comment=blogcommentService.getCommentById(commentId);
				//user=userService.getVo_AdminEdit(comment.getCreatorId());
				user=userService.getuserById(comment.getCreatorId());
				log.debug("当前需要回复邮件的地址"+user.getAccountEmail());
				log.debug("当前邮件是否需要回复(0否  1是)"+comment.getDynamicNotice());
				if(comment.getDynamicNotice()==1){
					//需要回复
					mailService.sendEmail(user.getAccountEmail(),"【易军博客】您有一条新的评论回复", userVo.getNickName()
							+"回复您:<"+blogcommentVo.getCommentContent()+">");
					log.debug("邮件发送内容+"+userVo.getNickName()
							+"回复您:<"+blogcommentVo.getCommentContent()+">");
				}
				//发送消息(维护)
				NoticeVo notice=new NoticeVo();
				notice.setActorId(userVo.getUserId());
				notice.setActorName(userVo.getNickName());
				notice.setBlogId(blogcommentVo.getBlogId());
				notice.setBlogTitle(blogcontentService.findContentById(blogcommentVo.getBlogId()).getTitle());
				notice.setOperateType(NoticeVo.OPERATE_RECOMMENT);
				notice.setState(NoticeVo.STATE_UNREAD);
				notice.setComment(blogcommentVo.getCommentContent());
				notice.setCommentId(blogcommentVo.getRefCommentId());
				notice.setCreateTime(new Date());
				noticeService.addNotice(notice, blogService.findBlogById(blogId).getCreatorId());
			}else if(i==0){
				//失败
				result.setStatus(JsonCrudModel.Status_Error);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 测试后台的评论数据
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "back/blogDetail" ,method=RequestMethod.GET )
	public String deleteCommentinfo(Model model,Integer blogId,@Param("page") Page page) throws Exception{
		//创建一个map接收
		jedisBlogLivenessService.flush(blogId);	
		BlogcontentVo blogcontentVo = blogcontentService.findContentById(blogId);
		blogcontentVo.setClick(jedisBlogLivenessService.getBlogLivenessCount
						(blogcontentVo.getBlogId(), JedisBlogLivenessServiceImpl.INDEX_CLICK));   
		model.addAttribute("blogcontentVo", blogcontentVo);
		
		int count =blogcommentService.getAllCountByBlogId(blogId);
		//log.debug("个数"+count);
		//log.debug("进入");
		model.addAttribute("count", count);
		page.setTotalCount(count);
		Map<BlogcommentVo, List<BlogcommentVo>> result=
				blogcommentService.getReplayCommentByCommentIdMap(page.getStartPos(),page.getPageSize(), blogId);
		model.addAttribute("list", result);
		log.debug("单前总数+"+page.getTotalCount());
		log.debug("当前的页数+"+page.getPageNow());
		model.addAttribute("page", page);
		return LISt_PAGE2;
	}
	
	/**删除一条主评论连带删除下面所有
	 * @param commentid
	 * @return
	 */
	@RequestMapping(value="delete", method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<BlogcommentVo> deleteComment(Integer commentid){
		final JsonCrudModel<BlogcommentVo> result = new JsonCrudModel<BlogcommentVo>();
		//获取当前主评论的id，找出下面的子平路你的id
		//创建一个集合接收
		List<Integer> commentids= new ArrayList<Integer>();
		try {
			blogcommentService.getAllCommentIdByComeentId(commentid, commentids);
			//开始删除主评论
			int i=blogcommentService.deleteAllCommentByCommentId(commentid);
			for(Integer integer:commentids){
				//(子评论开始删除)进行删除
				log.debug(""+integer);
				i=blogcommentService.deleteAllCommentByCommentId(integer);
			}
			if(i>0){
				//成功
				result.setStatus(JsonCrudModel.Status_Success);
			}else{
				//失败
				result.setStatus(JsonCrudModel.Status_Error);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
