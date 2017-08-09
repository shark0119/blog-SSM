
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class AnnouncementSearch extends BaseSearch {

	private static final long serialVersionUID = 5402839257857156224L;
	/**
     *AnnouncementId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqAnnouncementId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neAnnouncementId;
    /**
     *creatorId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqCreatorId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neCreatorId;
    /**
     * Content(600)
	 * dbValue == thisValue
	 */
    private String eqContent;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkContent;
    /**
     * CreateDate
	 * dbValue = thisValue (yyyy-MM-dd)
	 */
    private java.util.Date eqCreateDate; 
    /**
	 * dbValue >= thisValue (yyyy-MM-dd HH:mm:ss SSS)
	 */
    private java.util.Date geCreateDate;
    /**
	 * dbValue < thisValue (yyyy-MM-dd HH:mm:ss SSS)
	 */
    private java.util.Date ltCreateDate;

    
    public Integer getEqAnnouncementId() {
        return eqAnnouncementId;
    }
    public Integer getNeAnnouncementId() {
        return neAnnouncementId;
    }
    
    public Integer getEqCreatorId() {
        return eqCreatorId;
    }
    public Integer getNeCreatorId() {
        return neCreatorId;
    }
    
    public String getEqContent() {
        return eqContent;
    }
    public String getLkContent() {
        return lkContent;
    }
    
    public java.util.Date getEqCreateDate() {
        return eqCreateDate;
    }
    public java.util.Date getGeCreateDate() {
        return geCreateDate;
    }
    public java.util.Date getLtCreateDate() {
        return ltCreateDate;
    }
    public void setEqAnnouncementId(Integer eqAnnouncementId) {
		this.eqAnnouncementId = eqAnnouncementId;
	}
    public void setNeAnnouncementId(Integer neAnnouncementId) {
		this.neAnnouncementId = neAnnouncementId;
	}
    public void setEqCreatorId(Integer eqCreatorId) {
		this.eqCreatorId = eqCreatorId;
	}
    public void setNeCreatorId(Integer neCreatorId) {
		this.neCreatorId = neCreatorId;
	}

	public void setEqContent(String eqContent) {
		this.eqContent = eqContent;
	}
    public void setLkContent(String lkContent) {
		this.lkContent = lkContent;
	}
    public void setEqCreateDate(java.util.Date eqCreateDate) {
		this.eqCreateDate = eqCreateDate;
	}
    public void setGeCreateDate(java.util.Date geCreateDate) {
		this.geCreateDate = geCreateDate;
	}
    public void setLtCreateDate(java.util.Date ltCreateDate) {
		this.ltCreateDate = ltCreateDate;
	}

}
