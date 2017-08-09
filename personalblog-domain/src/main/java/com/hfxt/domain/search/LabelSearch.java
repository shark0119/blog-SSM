
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class LabelSearch extends BaseSearch {

	private static final long serialVersionUID = -7806354682721969722L;
	/**
     *LabelId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqLabelId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neLabelId;
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
     * LabelName(60)
	 * dbValue == thisValue
	 */
    private String eqLabelName;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkLabelName;

    
    public Integer getEqLabelId() {
        return eqLabelId;
    }
    public Integer getNeLabelId() {
        return neLabelId;
    }
    
    public Integer getEqCreatorId() {
        return eqCreatorId;
    }
    public Integer getNeCreatorId() {
        return neCreatorId;
    }
    
    public String getEqLabelName() {
        return eqLabelName;
    }
    public String getLkLabelName() {
        return lkLabelName;
    }
    public void setEqLabelId(Integer eqLabelId) {
		this.eqLabelId = eqLabelId;
	}
    public void setNeLabelId(Integer neLabelId) {
		this.neLabelId = neLabelId;
	}
    public void setEqCreatorId(Integer eqCreatorId) {
		this.eqCreatorId = eqCreatorId;
	}
    public void setNeCreatorId(Integer neCreatorId) {
		this.neCreatorId = neCreatorId;
	}

	public void setEqLabelName(String eqLabelName) {
		this.eqLabelName = eqLabelName;
	}
    public void setLkLabelName(String lkLabelName) {
		this.lkLabelName = lkLabelName;
	}

}
