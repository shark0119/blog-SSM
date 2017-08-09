package com.hfxt.web.controller.user;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hfxt.domain.vo.NoticeVo;
import com.hfxt.domain.vo.UserVo;
import com.hfxt.web.controller.BaseController;

import common.model.JsonCrudModel;

@Controller("NoticeController")
public class NoticeController extends BaseController{
	
	private static final String PAGE_NOTICE = "notice/notice";
	
	private Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@RequestMapping(value="/noticeList", method=RequestMethod.GET)
	public ModelAndView noticeList (HttpSession session){
		logger.debug("消息列表展示");
		ModelAndView mv = new ModelAndView ();
		UserVo user = (UserVo) session.getAttribute("SYS_USER");
		logger.debug("为空");
		try {
			List<NoticeVo> notices = noticeService.getNoticeByUserId(user.getUserId());
			Collections.sort(notices);
			mv.addObject("unreadNoticeCount" , noticeService.getUnreadNoticeCount(user.getUserId()));
				mv.addObject("noticeList", notices);
		} catch (Exception e) {
			logger.info("发生异常" + e);
			e.printStackTrace();
		}
		mv.setViewName(PAGE_NOTICE);
		return mv;
	}
	
	@RequestMapping(value="/setAllReaded", method=RequestMethod.GET)
	public String setAllReaded (HttpSession session){
		UserVo user = (UserVo) session.getAttribute("SYS_USER");
		try {
			List<NoticeVo> notices = noticeService.getNoticeByUserId(user.getUserId());
			for (NoticeVo notice : notices){
				if (notice.getState().equals(NoticeVo.STATE_UNREAD)){
					notice.setState(NoticeVo.STATE_READED);
					noticeService.addNotice(notice, user.getUserId());
				}
			}
		} catch (Exception e) {
			logger.info("发生异常" + e);
			e.printStackTrace();
		}
		return "redirect:noticeList";
	}
	@RequestMapping(value="/deleteNotices", method=RequestMethod.GET)
	public String deleteNotices (String [] noticeIds, HttpSession session){
		UserVo user = (UserVo) session.getAttribute("SYS_USER");
		for (String noticeId : noticeIds){
			try {
				noticeService.deleteNotice(noticeId, user.getUserId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:noticeList";
	}
	@RequestMapping (value="/deleteAllNotices", method=RequestMethod.GET)
	public String deleteAllNotices (HttpSession session){
		UserVo user = (UserVo) session.getAttribute("SYS_USER");
		try {
			noticeService.deleteAllNotices(user.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("删除失败" + e);
		}
		return "redirect:noticeList";
	}
	
	/**批量删除
	 * @return
	 */
	@RequestMapping(value="/alldeleteNot",method=RequestMethod.POST)
	@ResponseBody
	public JsonCrudModel<NoticeVo> allDelete(String ids,HttpSession session){
		final JsonCrudModel<NoticeVo> result = new JsonCrudModel<NoticeVo>();
		UserVo userVo=(UserVo) session.getAttribute("SYS_USER");
		//解析数组
		String[] idStrings=ids.split(",");
		for(String id:idStrings){
			try {
				noticeService.deleteNotice(id, userVo.getUserId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		result.setStatus(JsonCrudModel.Status_Success);
		return result;
		
	}
}
