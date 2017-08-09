

package com.hfxt.domain.vo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class TrightVo extends BaseVo {

	private static final long serialVersionUID = 6643330823086845861L;

	/** identifier field */

	private String tightid;
    
	/** identifier field */

	private String rightparentcode;
    
	/** identifier field */

	private String righttitle;
    
	/** identifier field */

	private String righturl;
    

	/**
	 * @return 返回 tightid。
	 */
	public String getTightid() {
		return tightid;
	}

	/**
	 * @param tightid 要设置的 tightid。
	 */
	public void setTightid(String tightid) {
		this.tightid = tightid;
	}
	/**
	 * @return 返回 rightparentcode。
	 */
	public String getRightparentcode() {
		return rightparentcode;
	}

	/**
	 * @param rightparentcode 要设置的 rightparentcode。
	 */
	public void setRightparentcode(String rightparentcode) {
		this.rightparentcode = rightparentcode;
	}
	/**
	 * @return 返回 righttitle。
	 */
	public String getRighttitle() {
		return righttitle;
	}

	/**
	 * @param righttitle 要设置的 righttitle。
	 */
	public void setRighttitle(String righttitle) {
		this.righttitle = righttitle;
	}
	/**
	 * @return 返回 righturl。
	 */
	public String getRighturl() {
		return righturl;
	}

	/**
	 * @param righturl 要设置的 righturl。
	 */
	public void setRighturl(String righturl) {
		this.righturl = righturl;
	}
}
