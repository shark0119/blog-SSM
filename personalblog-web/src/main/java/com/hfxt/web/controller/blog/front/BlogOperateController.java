package com.hfxt.web.controller.blog.front;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hfxt.domain.vo.NoticeVo;
import com.hfxt.domain.vo.UserVo;
import com.hfxt.service.impl.JedisBlogLivenessServiceImpl;
import com.hfxt.web.controller.BaseController;

import common.utils.NetworkUtil;

@Controller("BlogOperateController")
public class BlogOperateController extends BaseController{
	
	private Logger logger = LoggerFactory.getLogger (BlogOperateController.class);
	
	@RequestMapping(method = RequestMethod.POST, value = "front/blog/good")
	@ResponseBody
	public Map<String, Object> good (boolean inc, int blogId, HttpServletRequest request){
		UserVo user = (UserVo) request.getSession().getAttribute("SYS_USER");
		if (user == null){
			user = new UserVo();
			user.setUserId(-1);
		}
		Map <String ,Object> resultMap = new HashMap<String, Object>();
		String ipAddress;
		try {
			ipAddress = NetworkUtil.getIpAddress(request);
			NoticeVo notice = new NoticeVo();
			notice.setActorId(user.getUserId());
			notice.setActorName(user.getNickName());
			notice.setBlogId(blogId);
			notice.setBlogTitle(blogcontentService.findContentById(blogId).getTitle());
			notice.setOperateType(NoticeVo.OPERATE_LIKE);
			notice.setState(NoticeVo.STATE_UNREAD);
			notice.setCreateTime(new Date());
			if (inc){
				jedisBlogLivenessService.blogAddLiveness(user.getUserId(), ipAddress, 
						blogId, JedisBlogLivenessServiceImpl.INDEX_GOOD);
				noticeService.addNotice(notice, 
						blogService.findBlogById(blogId).getCreatorId());
				logger.debug("点赞成功");
				resultMap.put("success", true);
			} else {
				jedisBlogLivenessService.blogDrawGood(user.getUserId(), ipAddress, blogId);
				logger.debug("撤销点赞成功");
				resultMap.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("点赞操作失败:" + e);
			resultMap.put("success", false);
		}
		return resultMap;
	}
	@RequestMapping(method = RequestMethod.POST, value = "front/blog/bad")
	@ResponseBody
	public Map<String, Object> bad (boolean inc, int blogId, HttpServletRequest request){
		UserVo user = (UserVo) request.getSession().getAttribute("SYS_USER");
		if (user == null){
			user = new UserVo();
			user.setUserId(-1);
		}
		Map <String ,Object> resultMap = new HashMap<String, Object>();
		String ipAddress;
		try {
			ipAddress = NetworkUtil.getIpAddress(request);
			NoticeVo notice = new NoticeVo();
			notice.setActorId(user.getUserId());
			notice.setActorName(user.getNickName());
			notice.setBlogId(blogId);
			notice.setBlogTitle(blogcontentService.findContentById(blogId).getTitle());
			notice.setOperateType(NoticeVo.OPERATE_DISLIKE);
			notice.setState(NoticeVo.STATE_UNREAD);
			notice.setCreateTime(new Date());
			if (inc){
				jedisBlogLivenessService.blogAddLiveness(user.getUserId(), ipAddress, 
						blogId, JedisBlogLivenessServiceImpl.INDEX_BAD);
				noticeService.addNotice(notice, 
						blogService.findBlogById(blogId).getCreatorId());
				logger.debug("踩成功");
				resultMap.put("success", true);
			} else {
				jedisBlogLivenessService.blogDrawBad(user.getUserId(), ipAddress, blogId);
				logger.debug("撤销踩成功");
				resultMap.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("踩操作失败:" + e);
			resultMap.put("success", false);
		}
		return resultMap;
	}
}
