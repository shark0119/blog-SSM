
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class BloglivenessSearch extends BaseSearch {

	private static final long serialVersionUID = -4918507458618667684L;
	/**
     *BlogLivenessId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqBlogLivenessId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neBlogLivenessId;
    /**
     *ReceiveGoods(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqReceiveGoods;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neReceiveGoods;
    /**
     *ReceiveComments(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqReceiveComments;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neReceiveComments;
    /**
     *ReceiveClickRate(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqReceiveClickRate;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neReceiveClickRate;
    /**
     *ReceiveBads(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqReceiveBads;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neReceiveBads;
    /**
     * TimeQuantum
	 * dbValue = thisValue (yyyy-MM-dd)
	 */
    private java.util.Date eqTimeQuantum; 
    /**
	 * dbValue >= thisValue (yyyy-MM-dd HH:mm:ss SSS)
	 */
    private java.util.Date geTimeQuantum;
    /**
	 * dbValue < thisValue (yyyy-MM-dd HH:mm:ss SSS)
	 */
    private java.util.Date ltTimeQuantum;
    /**
     *BlogId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqBlogId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neBlogId;

    
    public Integer getEqBlogLivenessId() {
        return eqBlogLivenessId;
    }
    public Integer getNeBlogLivenessId() {
        return neBlogLivenessId;
    }
    
    public Integer getEqReceiveGoods() {
        return eqReceiveGoods;
    }
    public Integer getNeReceiveGoods() {
        return neReceiveGoods;
    }
    
    public Integer getEqReceiveComments() {
        return eqReceiveComments;
    }
    public Integer getNeReceiveComments() {
        return neReceiveComments;
    }
    
    public Integer getEqReceiveClickRate() {
        return eqReceiveClickRate;
    }
    public Integer getNeReceiveClickRate() {
        return neReceiveClickRate;
    }
    
    public Integer getEqReceiveBads() {
        return eqReceiveBads;
    }
    public Integer getNeReceiveBads() {
        return neReceiveBads;
    }
    
    public java.util.Date getEqTimeQuantum() {
        return eqTimeQuantum;
    }
    public java.util.Date getGeTimeQuantum() {
        return geTimeQuantum;
    }
    public java.util.Date getLtTimeQuantum() {
        return ltTimeQuantum;
    }
    
    public Integer getEqBlogId() {
        return eqBlogId;
    }
    public Integer getNeBlogId() {
        return neBlogId;
    }
    public void setEqBlogLivenessId(Integer eqBlogLivenessId) {
		this.eqBlogLivenessId = eqBlogLivenessId;
	}
    public void setNeBlogLivenessId(Integer neBlogLivenessId) {
		this.neBlogLivenessId = neBlogLivenessId;
	}
    public void setEqReceiveGoods(Integer eqReceiveGoods) {
		this.eqReceiveGoods = eqReceiveGoods;
	}
    public void setNeReceiveGoods(Integer neReceiveGoods) {
		this.neReceiveGoods = neReceiveGoods;
	}
    public void setEqReceiveComments(Integer eqReceiveComments) {
		this.eqReceiveComments = eqReceiveComments;
	}
    public void setNeReceiveComments(Integer neReceiveComments) {
		this.neReceiveComments = neReceiveComments;
	}
    public void setEqReceiveClickRate(Integer eqReceiveClickRate) {
		this.eqReceiveClickRate = eqReceiveClickRate;
	}
    public void setNeReceiveClickRate(Integer neReceiveClickRate) {
		this.neReceiveClickRate = neReceiveClickRate;
	}
    public void setEqReceiveBads(Integer eqReceiveBads) {
		this.eqReceiveBads = eqReceiveBads;
	}
    public void setNeReceiveBads(Integer neReceiveBads) {
		this.neReceiveBads = neReceiveBads;
	}
    public void setEqTimeQuantum(java.util.Date eqTimeQuantum) {
		this.eqTimeQuantum = eqTimeQuantum;
	}
    public void setGeTimeQuantum(java.util.Date geTimeQuantum) {
		this.geTimeQuantum = geTimeQuantum;
	}
    public void setLtTimeQuantum(java.util.Date ltTimeQuantum) {
		this.ltTimeQuantum = ltTimeQuantum;
	}
    public void setEqBlogId(Integer eqBlogId) {
		this.eqBlogId = eqBlogId;
	}
    public void setNeBlogId(Integer neBlogId) {
		this.neBlogId = neBlogId;
	}

}
