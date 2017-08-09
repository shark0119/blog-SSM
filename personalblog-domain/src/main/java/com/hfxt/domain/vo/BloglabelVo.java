

package com.hfxt.domain.vo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class BloglabelVo extends BaseVo {

	private static final long serialVersionUID = -4482374731657003609L;

	/** identifier field */

	private Integer blogLabelId;
    
	/** identifier field */

	private Integer blogId;
    
	/** identifier field */

	private Integer labelId;
    

	/**
	 * @return 返回 blogLabelId。
	 */
	public Integer getBlogLabelId() {
		return blogLabelId;
	}

	/**
	 * @param blogLabelId 要设置的 blogLabelId。
	 */
	public void setBlogLabelId(Integer blogLabelId) {
		this.blogLabelId = blogLabelId;
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
