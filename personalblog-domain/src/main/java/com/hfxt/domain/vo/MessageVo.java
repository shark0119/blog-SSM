

package com.hfxt.domain.vo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class MessageVo extends BaseVo {

	private static final long serialVersionUID = -4797313660187590239L;

	/** identifier field */

	private Integer messageId;
    
	/** identifier field */

	private Integer senderId;
    
	/** identifier field */

	private Integer receiverId;
    
	/** identifier field */

	private String content;
    
	/** identifier field */

	private java.util.Date createDate;
    

	/**
	 * @return 返回 messageId。
	 */
	public Integer getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId 要设置的 messageId。
	 */
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	/**
	 * @return 返回 senderId。
	 */
	public Integer getSenderId() {
		return senderId;
	}

	/**
	 * @param senderId 要设置的 senderId。
	 */
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	/**
	 * @return 返回 receiverId。
	 */
	public Integer getReceiverId() {
		return receiverId;
	}

	/**
	 * @param receiverId 要设置的 receiverId。
	 */
	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
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
