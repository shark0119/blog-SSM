

package com.hfxt.domain.vo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class SectionVo extends BaseVo {

	private static final long serialVersionUID = -472944964877535177L;

	/** identifier field */

	private Integer sectionId;
    
	/** identifier field */

	private String sectionName;
    
	/** identifier field */

	private Integer visiable;
	//总数
	private Integer count;
	//关键字
	private String keyWord;
	//描述
	private String description;
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
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
	 * @return 返回 sectionName。
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @param sectionName 要设置的 sectionName。
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
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
}
