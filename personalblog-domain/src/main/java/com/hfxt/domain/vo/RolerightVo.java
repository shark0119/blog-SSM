

package com.hfxt.domain.vo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class RolerightVo extends BaseVo {

	private static final long serialVersionUID = 522432698769704984L;

	/** identifier field */

	private Integer id;
    
	/** identifier field */

	private String rightcode;
    
	/** identifier field */

	private Integer role1id;
    

	/**
	 * @return 返回 id。
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id 要设置的 id。
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return 返回 rightcode。
	 */
	public String getRightcode() {
		return rightcode;
	}

	/**
	 * @param rightcode 要设置的 rightcode。
	 */
	public void setRightcode(String rightcode) {
		this.rightcode = rightcode;
	}
	/**
	 * @return 返回 role1id。
	 */
	public Integer getRole1id() {
		return role1id;
	}

	/**
	 * @param role1id 要设置的 role1id。
	 */
	public void setRole1id(Integer role1id) {
		this.role1id = role1id;
	}
}
