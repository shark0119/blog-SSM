

package com.hfxt.domain.vo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class UserlabelVo extends BaseVo {

	private static final long serialVersionUID = -3102035023180280081L;

	/** identifier field */

	private Integer userLabelId;
    
	/** identifier field */

	private Integer creatorId;
    
	/** identifier field */

	private Integer labelId;
    

	/**
	 * @return 返回 userLabelId。
	 */
	public Integer getUserLabelId() {
		return userLabelId;
	}

	/**
	 * @param userLabelId 要设置的 userLabelId。
	 */
	public void setUserLabelId(Integer userLabelId) {
		this.userLabelId = userLabelId;
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
	 * @return 返回 labelId。
	 */
	public Integer getLabelId() {
		return labelId;
	}

	/**
	 * @param labelId 要设置的 labelId。
	 */
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
}
