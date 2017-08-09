

package com.hfxt.domain.vo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class LabelVo extends BaseVo {

	private static final long serialVersionUID = 7318006924440320460L;

	/** identifier field */

	private Integer labelId;
    
	/** identifier field */

	private Integer creatorId;
    
	/** identifier field */

	private String labelName;
    

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
	 * @return 返回 labelName。
	 */
	public String getLabelName() {
		return labelName;
	}

	/**
	 * @param labelName 要设置的 labelName。
	 */
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
}
