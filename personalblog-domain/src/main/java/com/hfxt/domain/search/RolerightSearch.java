
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class RolerightSearch extends BaseSearch {

	private static final long serialVersionUID = 25231957362109417L;
	/**
     *id(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neId;
    /**
     * rightcode(60)
	 * dbValue == thisValue
	 */
    private String eqRightcode;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkRightcode;
    /**
     *role1id(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqRole1id;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neRole1id;

    
    public Integer getEqId() {
        return eqId;
    }
    public Integer getNeId() {
        return neId;
    }
    
    public String getEqRightcode() {
        return eqRightcode;
    }
    public String getLkRightcode() {
        return lkRightcode;
    }
    
    public Integer getEqRole1id() {
        return eqRole1id;
    }
    public Integer getNeRole1id() {
        return neRole1id;
    }
    public void setEqId(Integer eqId) {
		this.eqId = eqId;
	}
    public void setNeId(Integer neId) {
		this.neId = neId;
	}

	public void setEqRightcode(String eqRightcode) {
		this.eqRightcode = eqRightcode;
	}
    public void setLkRightcode(String lkRightcode) {
		this.lkRightcode = lkRightcode;
	}
    public void setEqRole1id(Integer eqRole1id) {
		this.eqRole1id = eqRole1id;
	}
    public void setNeRole1id(Integer neRole1id) {
		this.neRole1id = neRole1id;
	}

}
