

package com.hfxt.domain.vo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class RoleVo extends BaseVo {

	private static final long serialVersionUID = -8346205295035482258L;
	
	public static final Integer ADMIN = 1;
	public static final Integer USER = 2;

	/** identifier field */

	private Integer roleid;
    
	/** identifier field */

	private String rolename;
    

	/**
	 * @return 返回 roleid。
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * @param roleid 要设置的 roleid。
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	/**
	 * @return 返回 rolename。
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * @param rolename 要设置的 rolename。
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
