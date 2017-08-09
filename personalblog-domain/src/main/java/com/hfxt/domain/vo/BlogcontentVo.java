

package com.hfxt.domain.vo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class BlogcontentVo extends BaseVo {

	private static final long serialVersionUID = 7798874474748120386L;

	
	
	private int good, bad ,comment,click,newGood, newBad ,newComment,newClick;
	
	
	private String nickName;
	
	private Integer checkArticle;
	
	private Integer userId;
	
	private String sectionName;
	
	private java.util.Date createDate;
	
	private Integer draftContent;
	
	private Integer visiable;
	
	private Integer blogId;
	
	/** identifier field */

	private Integer blogContentId;
    
	/** identifier field */

	private String title;
    
	/** identifier field */

	private String abstrac;
    
	/** identifier field */

	private String content;
    

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
	 * @return 返回 title。
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title 要设置的 title。
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return 返回 abstrac。
	 */
	public String getAbstrac() {
		return abstrac;
	}

	/**
	 * @param abstrac 要设置的 abstrac。
	 */
	public void setAbstrac(String abstrac) {
		this.abstrac = abstrac;
	}
	/**
	 * @return 返回 content。
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content 要设置的 content。
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public Integer getVisiable() {
		return visiable;
	}

	public void setVisiable(Integer visiable) {
		this.visiable = visiable;
	}

	public Integer getDraftContent() {
		return draftContent;
	}

	public void setDraftContent(Integer draftContent) {
		this.draftContent = draftContent;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
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

	public Integer getGood() {
		return good;
	}

	public void setGood(Integer good) {
		this.good = good;
	}

	public Integer getBad() {
		return bad;
	}

	public void setBad(Integer bad) {
		this.bad = bad;
	}

	public Integer getComment() {
		return comment;
	}

	public void setComment(Integer comment) {
		this.comment = comment;
	}

	public Integer getClick() {
		return click;
	}

	public void setClick(Integer click) {
		this.click = click;
	}

	public Integer getNewGood() {
		return newGood;
	}

	public void setNewGood(Integer newGood) {
		this.newGood = newGood;
	}

	public Integer getNewBad() {
		return newBad;
	}

	public void setNewBad(Integer newBad) {
		this.newBad = newBad;
	}

	public Integer getNewComment() {
		return newComment;
	}

	public void setNewComment(Integer newComment) {
		this.newComment = newComment;
	}

	public Integer getNewClick() {
		return newClick;
	}

	public void setNewClick(Integer newClick) {
		this.newClick = newClick;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}
