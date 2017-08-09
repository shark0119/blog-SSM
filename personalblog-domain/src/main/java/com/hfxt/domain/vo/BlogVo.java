

package com.hfxt.domain.vo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class BlogVo extends BaseVo {

	private static final long serialVersionUID = 4680275238574347911L;

	/** identifier field */

	
	private Integer checkArticle;
	
	private Integer userId;
	
	private Integer draftContent;
	
	private Integer blogId;
    
	/** identifier field */

	private Integer creatorId;
    
	/** identifier field */

	private Integer sectionId;
    
	/** identifier field */

	private Integer blogContentId;
    
	/** identifier field */

	private Integer blogNewLivenessId;
    
	/** identifier field */

	private java.util.Date createDate;
    
	/** identifier field */

	private java.util.Date releaseDate;
    
	/** identifier field */

	private Integer visiable;
    
	/** identifier field */

	private Integer dynamicNotice;
    
	/** identifier field */

	private Integer commentApprove;
    

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
	 * @return 返回 sectionId。
	 */
	public Integer getSectionId() {
		return sectionId;
	}

	/**
	 * @param sectionId 要设置的 sectionId。
	 */
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	/**
	 * @return 返回 blogContentId。
	 */
	public Integer getBlogContentId() {
		return blogContentId;
	}

	/**
	 * @param blogContentId 要设置的 blogContentId。
	 */
	public void setBlogContentId(Integer blogContentId) {
		this.blogContentId = blogContentId;
	}
	/**
	 * @return 返回 blogNewLivenessId。
	 */
	public Integer getBlogNewLivenessId() {
		return blogNewLivenessId;
	}

	/**
	 * @param blogNewLivenessId 要设置的 blogNewLivenessId。
	 */
	public void setBlogNewLivenessId(Integer blogNewLivenessId) {
		this.blogNewLivenessId = blogNewLivenessId;
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
	 * @return 返回 releaseDate。
	 */
	public java.util.Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate 要设置的 releaseDate。
	 */
	public void setReleaseDate(java.util.Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	/**
	 * @return 返回 visiable。
	 */
	public Integer getVisiable() {
		return visiable;
	}

	/**
	 * @param visiable 要设置的 visiable。
	 */
	public void setVisiable(Integer visiable) {
		this.visiable = visiable;
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
	 * @return 返回 commentApprove。
	 */
	public Integer getCommentApprove() {
		return commentApprove;
	}

	/**
	 * @param commentApprove 要设置的 commentApprove。
	 */
	public void setCommentApprove(Integer commentApprove) {
		this.commentApprove = commentApprove;
	}

	public Integer getDraftContent() {
		return draftContent;
	}

	public void setDraftContent(Integer draftContent) {
		this.draftContent = draftContent;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCheckArticle() {
		return checkArticle;
	}

	public void setCheckArticle(Integer checkArticle) {
		this.checkArticle = checkArticle;
	}


	
	
}
