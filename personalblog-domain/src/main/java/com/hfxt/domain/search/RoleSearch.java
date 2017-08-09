
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class RoleSearch extends BaseSearch {

	private static final long serialVersionUID = 2009117565445525119L;
	/**
     *roleid(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqRoleid;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neRoleid;
    /**
     * rolename(90)
	 * dbValue == thisValue
	 */
    private String eqRolename;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkRolename;

    
    public Integer getEqRoleid() {
        return eqRoleid;
    }
    public Integer getNeRoleid() {
        return neRoleid;
    }
    
    public String getEqRolename() {
        return eqRolename;
    }
    public String getLkRolename() {
        return lkRolename;
    }
    public void setEqRoleid(Integer eqRoleid) {
		this.eqRoleid = eqRoleid;
	}
    public void setNeRoleid(Integer neRoleid) {
		this.neRoleid = neRoleid;
	}

	public void setEqRolename(String eqRolename) {
		this.eqRolename = eqRolename;
	}
    public void setLkRolename(String lkRolename) {
		this.lkRolename = lkRolename;
	}

}
