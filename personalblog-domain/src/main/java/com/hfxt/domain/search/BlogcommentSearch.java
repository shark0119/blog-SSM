
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class BlogcommentSearch extends BaseSearch {

	private static final long serialVersionUID = -805688325979208753L;
	/**
     *CommentId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqCommentId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neCommentId;
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
     *RefCommentId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqRefCommentId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neRefCommentId;
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
    /**
     * CommentContent(150)
	 * dbValue == thisValue
	 */
    private String eqCommentContent;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkCommentContent;
    /**
     *DynamicNotice(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqDynamicNotice;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neDynamicNotice;
    /**
     *state(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqState;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neState;

    
    public Integer getEqCommentId() {
        return eqCommentId;
    }
    public Integer getNeCommentId() {
        return neCommentId;
    }
    
    public Integer getEqBlogId() {
        return eqBlogId;
    }
    public Integer getNeBlogId() {
        return neBlogId;
    }
    
    public Integer getEqRefCommentId() {
        return eqRefCommentId;
    }
    public Integer getNeRefCommentId() {
        return neRefCommentId;
    }
    
    public Integer getEqCreatorId() {
        return eqCreatorId;
    }
    public Integer getNeCreatorId() {
        return neCreatorId;
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
    
    public String getEqCommentContent() {
        return eqCommentContent;
    }
    public String getLkCommentContent() {
        return lkCommentContent;
    }
    
    public Integer getEqDynamicNotice() {
        return eqDynamicNotice;
    }
    public Integer getNeDynamicNotice() {
        return neDynamicNotice;
    }
    
    public Integer getEqState() {
        return eqState;
    }
    public Integer getNeState() {
        return neState;
    }
    public void setEqCommentId(Integer eqCommentId) {
		this.eqCommentId = eqCommentId;
	}
    public void setNeCommentId(Integer neCommentId) {
		this.neCommentId = neCommentId;
	}
    public void setEqBlogId(Integer eqBlogId) {
		this.eqBlogId = eqBlogId;
	}
    public void setNeBlogId(Integer neBlogId) {
		this.neBlogId = neBlogId;
	}
    public void setEqRefCommentId(Integer eqRefCommentId) {
		this.eqRefCommentId = eqRefCommentId;
	}
    public void setNeRefCommentId(Integer neRefCommentId) {
		this.neRefCommentId = neRefCommentId;
	}
    public void setEqCreatorId(Integer eqCreatorId) {
		this.eqCreatorId = eqCreatorId;
	}
    public void setNeCreatorId(Integer neCreatorId) {
		this.neCreatorId = neCreatorId;
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

	public void setEqCommentContent(String eqCommentContent) {
		this.eqCommentContent = eqCommentContent;
	}
    public void setLkCommentContent(String lkCommentContent) {
		this.lkCommentContent = lkCommentContent;
	}
    public void setEqDynamicNotice(Integer eqDynamicNotice) {
		this.eqDynamicNotice = eqDynamicNotice;
	}
    public void setNeDynamicNotice(Integer neDynamicNotice) {
		this.neDynamicNotice = neDynamicNotice;
	}
    public void setEqState(Integer eqState) {
		this.eqState = eqState;
	}
    public void setNeState(Integer neState) {
		this.neState = neState;
	}

}
