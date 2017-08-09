

package com.hfxt.domain.vo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class AnnouncementVo extends BaseVo {

	private static final long serialVersionUID = -8162570837196669677L;

	/** identifier field */

	private Integer announcementId;
    
	/** identifier field */

	private Integer creatorId;
    
	/** identifier field */

	private String content;
    
	/** identifier field */

	private java.util.Date createDate;
    

	/**
	 * @return 返回 announcementId。
	 */
	public Integer getAnnouncementId() {
		return announcementId;
	}

	/**
	 * @param announcementId 要设置的 announcementId。
	 */
	public void setAnnouncementId(Integer announcementId) {
		this.announcementId = announcementId;
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
}
