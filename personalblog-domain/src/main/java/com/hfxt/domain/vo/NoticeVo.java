package com.hfxt.domain.vo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用于存储消息实体 utf-8
 * 
 * @author Shark
 *
 */
public class NoticeVo implements Comparable<NoticeVo> {

	public static final String STATE_UNREAD = "unread";
	public static final String STATE_READED = "readed";

	public static final String OPERATE_COMMENT = "comment";
	public static final String OPERATE_LIKE = "like";
	public static final String OPERATE_DISLIKE = "dislike";
	public static final String OPERATE_RECOMMENT = "recomment";
	//留言
	public static final String OPERATE_MESSAGE = "message";

	@JSONField(name="noticeId")
	private String noticeId;
	@JSONField(name = "actorId")
	private Integer actorId;
	@JSONField(name = "actorName")
	private String actorName;
	@JSONField(name = "operateType")
	private String operateType;
	@JSONField(name = "blogId")
	private Integer blogId;
	@JSONField(name = "blogTitle")
	private String blogTitle;
	@JSONField(name = "commentId")
	private Integer commentId;
	@JSONField(name = "comment")
	private String comment;
	@JSONField(name = "state")
	private String state;
	@JSONField(name="createTime")
	private Date createTime;

	public NoticeVo() {
	}

	public static String getStateUnread() {
		return STATE_UNREAD;
	}

	public static String getStateReaded() {
		return STATE_READED;
	}

	public static String getOperateComment() {
		return OPERATE_COMMENT;
	}

	public static String getOperateLike() {
		return OPERATE_LIKE;
	}

	public static String getOperateDislike() {
		return OPERATE_DISLIKE;
	}

	public static String getOperateRecomment() {
		return OPERATE_RECOMMENT;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNoticeId() {
		return noticeId;
	}

	@Override
	public String toString() {
		return "NoticeVo [noticeId=" + noticeId + ", actorId=" + actorId + ", actorName=" + actorName + ", operateType="
				+ operateType + ", blogId=" + blogId + ", blogTitle=" + blogTitle + ", commentId=" + commentId
				+ ", comment=" + comment + ", state=" + state + ", createTime=" + createTime + "]";
	}

	public int compareTo(NoticeVo o) {
		if (createTime.getTime() > o.getCreateTime().getTime())
			return -1;
		else
			return 1;
	}

}