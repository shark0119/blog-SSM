
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class SectionSearch extends BaseSearch {

	private static final long serialVersionUID = -6160186339267008357L;
	/**
     *SectionId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqSectionId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neSectionId;
    /**
     * SectionName(60)
	 * dbValue == thisValue
	 */
    private String eqSectionName;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkSectionName;
    /**
     *Visiable(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqVisiable;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neVisiable;

    
    public Integer getEqSectionId() {
        return eqSectionId;
    }
    public Integer getNeSectionId() {
        return neSectionId;
    }
    
    public String getEqSectionName() {
        return eqSectionName;
    }
    public String getLkSectionName() {
        return lkSectionName;
    }
    
    public Integer getEqVisiable() {
        return eqVisiable;
    }
    public Integer getNeVisiable() {
        return neVisiable;
    }
    public void setEqSectionId(Integer eqSectionId) {
		this.eqSectionId = eqSectionId;
	}
    public void setNeSectionId(Integer neSectionId) {
		this.neSectionId = neSectionId;
	}

	public void setEqSectionName(String eqSectionName) {
		this.eqSectionName = eqSectionName;
	}
    public void setLkSectionName(String lkSectionName) {
		this.lkSectionName = lkSectionName;
	}
    public void setEqVisiable(Integer eqVisiable) {
		this.eqVisiable = eqVisiable;
	}
    public void setNeVisiable(Integer neVisiable) {
		this.neVisiable = neVisiable;
	}

}
