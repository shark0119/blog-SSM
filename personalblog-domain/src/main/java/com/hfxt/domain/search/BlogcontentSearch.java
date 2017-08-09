
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class BlogcontentSearch extends BaseSearch {

	private static final long serialVersionUID = -2774200848993476522L;
	/**
     *BlogContentId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqBlogContentId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neBlogContentId;
    /**
     * Title(150)
	 * dbValue == thisValue
	 */
    private String eqTitle;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkTitle;
    /**
     * Abstrac(300)
	 * dbValue == thisValue
	 */
    private String eqAbstrac;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkAbstrac;
    /**
     * Content(600)
	 * dbValue == thisValue
	 */
    private String eqContent;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkContent;

    
    public Integer getEqBlogContentId() {
        return eqBlogContentId;
    }
    public Integer getNeBlogContentId() {
        return neBlogContentId;
    }
    
    public String getEqTitle() {
        return eqTitle;
    }
    public String getLkTitle() {
        return lkTitle;
    }
    
    public String getEqAbstrac() {
        return eqAbstrac;
    }
    public String getLkAbstrac() {
        return lkAbstrac;
    }
    
    public String getEqContent() {
        return eqContent;
    }
    public String getLkContent() {
        return lkContent;
    }
    public void setEqBlogContentId(Integer eqBlogContentId) {
		this.eqBlogContentId = eqBlogContentId;
	}
    public void setNeBlogContentId(Integer neBlogContentId) {
		this.neBlogContentId = neBlogContentId;
	}

	public void setEqTitle(String eqTitle) {
		this.eqTitle = eqTitle;
	}
    public void setLkTitle(String lkTitle) {
		this.lkTitle = lkTitle;
	}

	public void setEqAbstrac(String eqAbstrac) {
		this.eqAbstrac = eqAbstrac;
	}
    public void setLkAbstrac(String lkAbstrac) {
		this.lkAbstrac = lkAbstrac;
	}

	public void setEqContent(String eqContent) {
		this.eqContent = eqContent;
	}
    public void setLkContent(String lkContent) {
		this.lkContent = lkContent;
	}

}
