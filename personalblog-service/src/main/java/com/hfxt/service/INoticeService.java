package com.hfxt.service;

import java.util.List;

import com.hfxt.domain.vo.NoticeVo;

public interface INoticeService {
	/**
	 * 获取未读的通知数
	 * @param receiverId 接受者
	 * @return 未读个数
	 * @throws Exception
	 */
	public int getUnreadNoticeCount (int receiverId) throws Exception;
	/**
	 * 添加通知
	 * @param notice 待保存的通知实体
	 * @param receiverId 被通知的用户ID
	 * @return 失败返回false
	 * @throws Exception
	 */
	public boolean addNotice (NoticeVo notice, int receiverId) throws Exception;
	/**
	 * 根据用户查询通知
	 * @param userId 用户ID
	 * @return 失败返回null
	 * @throws Exception
	 */
	public List<NoticeVo> getNoticeByUserId (int userId) throws Exception;
	/**
	 * 删除某个通知
	 * @param noticeId 通知ID
	 * @param userId 当前用户ID
	 * @return 失败返回false
	 * @throws Exception
	 */
	public boolean deleteNotice (String noticeId, int userId) throws Exception;
	/**
	 * 删除所有通知
	 * @param receiverId 当前用户ID
	 * @throws Exception
	 */
	public void deleteAllNotices (int receiverId) throws Exception;
}
