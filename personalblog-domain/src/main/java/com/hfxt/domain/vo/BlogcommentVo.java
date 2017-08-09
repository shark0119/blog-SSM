

package com.hfxt.domain.vo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class BlogcommentVo extends BaseVo {

	private static final long serialVersionUID = -7717479678710028337L;

	/** identifier field */

	private Integer commentId;
    
	/** identifier field */

	private Integer blogId;
    
	/** identifier field */

	private Integer refCommentId;
    
	/** identifier field */

	private Integer creatorId;
    
	/** identifier field */

	private java.util.Date createDate;
    
	/** identifier field */

	private String commentContent;
    
	/** identifier field */

	private Integer dynamicNotice;
    
	/** identifier field */

	private Integer state;
    
	private String addressorName;//回复人的姓名
	private String needreplyName;//需要回复的人的姓名
	
	public String getAddressorName() {
		return addressorName;
	}

	public void setAddressorName(String addressorName) {
		this.addressorName = addressorName;
	}

	public String getNeedreplyName() {
		return needreplyName;
	}

	public void setNeedreplyName(String needreplyName) {
		this.needreplyName = needreplyName;
	}

	/**
	 * @return 返回 commentId。
	 */
	public Integer getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId 要设置的 commentId。
	 */
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	/**
	 * @return 返回 blogId。
	 */
	public Integer getBlogId() {
		return blogId;
	}

	/**
	 * @param blogId 要设置的 blogId。
	 */
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	/**
	 * @return 返回 refCommentId。
	 */
	public Integer getRefCommentId() {
		return refCommentId;
	}

	/**
	 * @param refCommentId 要设置的 refCommentId。
	 */
	public void setRefCommentId(Integer refCommentId) {
		this.refCommentId = refCommentId;
	}
	/**
	 * @return 返回 creatorId。
	 */
	public Integer getCreatorId() {
		return creatorId;
	}

	/**
	 * @param creatorId 要设置的 creatorId。
	 */
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	/**
	 * @return 返回 createDate。
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate 要设置的 createDate。
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return 返回 commentContent。
	 */
	public String getCommentContent() {
		return commentContent;
	}

	/**
	 * @param commentContent 要设置的 commentContent。
	 */
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	/**
	 * @return 返回 dynamicNotice。
	 */
	public Integer getDynamicNotice() {
		return dynamicNotice;
	}

	/**
	 * @param dynamicNotice 要设置的 dynamicNotice。
	 */
	public void setDynamicNotice(Integer dynamicNotice) {
		this.dynamicNotice = dynamicNotice;
	}
	/**
	 * @return 返回 state。
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * @param state 要设置的 state。
	 */
	public void setState(Integer state) {
		this.state = state;
	}
}
