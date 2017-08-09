
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class UserlabelSearch extends BaseSearch {

	private static final long serialVersionUID = 6655485745113141343L;
	/**
     *UserLabelId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqUserLabelId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neUserLabelId;
    /**
     *CreatorId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqCreatorId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neCreatorId;
    /**
     *LabelId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqLabelId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neLabelId;

    
    public Integer getEqUserLabelId() {
        return eqUserLabelId;
    }
    public Integer getNeUserLabelId() {
        return neUserLabelId;
    }
    
    public Integer getEqCreatorId() {
        return eqCreatorId;
    }
    public Integer getNeCreatorId() {
        return neCreatorId;
    }
    
    public Integer getEqLabelId() {
        return eqLabelId;
    }
    public Integer getNeLabelId() {
        return neLabelId;
    }
    public void setEqUserLabelId(Integer eqUserLabelId) {
		this.eqUserLabelId = eqUserLabelId;
	}
    public void setNeUserLabelId(Integer neUserLabelId) {
		this.neUserLabelId = neUserLabelId;
	}
    public void setEqCreatorId(Integer eqCreatorId) {
		this.eqCreatorId = eqCreatorId;
	}
    public void setNeCreatorId(Integer neCreatorId) {
		this.neCreatorId = neCreatorId;
	}
    public void setEqLabelId(Integer eqLabelId) {
		this.eqLabelId = eqLabelId;
	}
    public void setNeLabelId(Integer neLabelId) {
		this.neLabelId = neLabelId;
	}

}
