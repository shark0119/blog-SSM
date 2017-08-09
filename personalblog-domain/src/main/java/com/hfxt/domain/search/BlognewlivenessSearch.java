
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class BlognewlivenessSearch extends BaseSearch {

	private static final long serialVersionUID = 9100431014251739425L;
	/**
     *BlogNewLivenessId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqBlogNewLivenessId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neBlogNewLivenessId;
    /**
     *NewGoods(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqNewGoods;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neNewGoods;
    /**
     *NewComments(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqNewComments;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neNewComments;
    /**
     *NewBads(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqNewBads;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neNewBads;
    /**
     *NewClickRate(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqNewClickRate;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neNewClickRate;

    
    public Integer getEqBlogNewLivenessId() {
        return eqBlogNewLivenessId;
    }
    public Integer getNeBlogNewLivenessId() {
        return neBlogNewLivenessId;
    }
    
    public Integer getEqNewGoods() {
        return eqNewGoods;
    }
    public Integer getNeNewGoods() {
        return neNewGoods;
    }
    
    public Integer getEqNewComments() {
        return eqNewComments;
    }
    public Integer getNeNewComments() {
        return neNewComments;
    }
    
    public Integer getEqNewBads() {
        return eqNewBads;
    }
    public Integer getNeNewBads() {
        return neNewBads;
    }
    
    public Integer getEqNewClickRate() {
        return eqNewClickRate;
    }
    public Integer getNeNewClickRate() {
        return neNewClickRate;
    }
    public void setEqBlogNewLivenessId(Integer eqBlogNewLivenessId) {
		this.eqBlogNewLivenessId = eqBlogNewLivenessId;
	}
    public void setNeBlogNewLivenessId(Integer neBlogNewLivenessId) {
		this.neBlogNewLivenessId = neBlogNewLivenessId;
	}
    public void setEqNewGoods(Integer eqNewGoods) {
		this.eqNewGoods = eqNewGoods;
	}
    public void setNeNewGoods(Integer neNewGoods) {
		this.neNewGoods = neNewGoods;
	}
    public void setEqNewComments(Integer eqNewComments) {
		this.eqNewComments = eqNewComments;
	}
    public void setNeNewComments(Integer neNewComments) {
		this.neNewComments = neNewComments;
	}
    public void setEqNewBads(Integer eqNewBads) {
		this.eqNewBads = eqNewBads;
	}
    public void setNeNewBads(Integer neNewBads) {
		this.neNewBads = neNewBads;
	}
    public void setEqNewClickRate(Integer eqNewClickRate) {
		this.eqNewClickRate = eqNewClickRate;
	}
    public void setNeNewClickRate(Integer neNewClickRate) {
		this.neNewClickRate = neNewClickRate;
	}

}
