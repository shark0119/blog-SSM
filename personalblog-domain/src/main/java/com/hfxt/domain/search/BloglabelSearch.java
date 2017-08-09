
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class BloglabelSearch extends BaseSearch {

	private static final long serialVersionUID = 2094290654331010285L;
	/**
     *BlogLabelId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqBlogLabelId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neBlogLabelId;
    /**
     *BlogId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqBlogId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neBlogId;
    /**
     *LabelId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqLabelId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neLabelId;

    
    public Integer getEqBlogLabelId() {
        return eqBlogLabelId;
    }
    public Integer getNeBlogLabelId() {
        return neBlogLabelId;
    }
    
    public Integer getEqBlogId() {
        return eqBlogId;
    }
    public Integer getNeBlogId() {
        return neBlogId;
    }
    
    public Integer getEqLabelId() {
        return eqLabelId;
    }
    public Integer getNeLabelId() {
        return neLabelId;
    }
    public void setEqBlogLabelId(Integer eqBlogLabelId) {
		this.eqBlogLabelId = eqBlogLabelId;
	}
    public void setNeBlogLabelId(Integer neBlogLabelId) {
		this.neBlogLabelId = neBlogLabelId;
	}
    public void setEqBlogId(Integer eqBlogId) {
		this.eqBlogId = eqBlogId;
	}
    public void setNeBlogId(Integer neBlogId) {
		this.neBlogId = neBlogId;
	}
    public void setEqLabelId(Integer eqLabelId) {
		this.eqLabelId = eqLabelId;
	}
    public void setNeLabelId(Integer neLabelId) {
		this.neLabelId = neLabelId;
	}

}
