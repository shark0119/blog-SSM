
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class BlogSearch extends BaseSearch {

	private static final long serialVersionUID = -8341561012229424537L;
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
     *creatorId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqCreatorId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neCreatorId;
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
     *BlogContentId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqBlogContentId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neBlogContentId;
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
     * ReleaseDate
	 * dbValue = thisValue (yyyy-MM-dd)
	 */
    private java.util.Date eqReleaseDate; 
    /**
	 * dbValue >= thisValue (yyyy-MM-dd HH:mm:ss SSS)
	 */
    private java.util.Date geReleaseDate;
    /**
	 * dbValue < thisValue (yyyy-MM-dd HH:mm:ss SSS)
	 */
    private java.util.Date ltReleaseDate;
    /**
     *Visiable(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqVisiable;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neVisiable;
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
     *CommentApprove(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqCommentApprove;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neCommentApprove;

    
    public Integer getEqBlogId() {
        return eqBlogId;
    }
    public Integer getNeBlogId() {
        return neBlogId;
    }
    
    public Integer getEqCreatorId() {
        return eqCreatorId;
    }
    public Integer getNeCreatorId() {
        return neCreatorId;
    }
    
    public Integer getEqSectionId() {
        return eqSectionId;
    }
    public Integer getNeSectionId() {
        return neSectionId;
    }
    
    public Integer getEqBlogContentId() {
        return eqBlogContentId;
    }
    public Integer getNeBlogContentId() {
        return neBlogContentId;
    }
    
    public Integer getEqBlogNewLivenessId() {
        return eqBlogNewLivenessId;
    }
    public Integer getNeBlogNewLivenessId() {
        return neBlogNewLivenessId;
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
    
    public java.util.Date getEqReleaseDate() {
        return eqReleaseDate;
    }
    public java.util.Date getGeReleaseDate() {
        return geReleaseDate;
    }
    public java.util.Date getLtReleaseDate() {
        return ltReleaseDate;
    }
    
    public Integer getEqVisiable() {
        return eqVisiable;
    }
    public Integer getNeVisiable() {
        return neVisiable;
    }
    
    public Integer getEqDynamicNotice() {
        return eqDynamicNotice;
    }
    public Integer getNeDynamicNotice() {
        return neDynamicNotice;
    }
    
    public Integer getEqCommentApprove() {
        return eqCommentApprove;
    }
    public Integer getNeCommentApprove() {
        return neCommentApprove;
    }
    public void setEqBlogId(Integer eqBlogId) {
		this.eqBlogId = eqBlogId;
	}
    public void setNeBlogId(Integer neBlogId) {
		this.neBlogId = neBlogId;
	}
    public void setEqCreatorId(Integer eqCreatorId) {
		this.eqCreatorId = eqCreatorId;
	}
    public void setNeCreatorId(Integer neCreatorId) {
		this.neCreatorId = neCreatorId;
	}
    public void setEqSectionId(Integer eqSectionId) {
		this.eqSectionId = eqSectionId;
	}
    public void setNeSectionId(Integer neSectionId) {
		this.neSectionId = neSectionId;
	}
    public void setEqBlogContentId(Integer eqBlogContentId) {
		this.eqBlogContentId = eqBlogContentId;
	}
    public void setNeBlogContentId(Integer neBlogContentId) {
		this.neBlogContentId = neBlogContentId;
	}
    public void setEqBlogNewLivenessId(Integer eqBlogNewLivenessId) {
		this.eqBlogNewLivenessId = eqBlogNewLivenessId;
	}
    public void setNeBlogNewLivenessId(Integer neBlogNewLivenessId) {
		this.neBlogNewLivenessId = neBlogNewLivenessId;
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
    public void setEqReleaseDate(java.util.Date eqReleaseDate) {
		this.eqReleaseDate = eqReleaseDate;
	}
    public void setGeReleaseDate(java.util.Date geReleaseDate) {
		this.geReleaseDate = geReleaseDate;
	}
    public void setLtReleaseDate(java.util.Date ltReleaseDate) {
		this.ltReleaseDate = ltReleaseDate;
	}
    public void setEqVisiable(Integer eqVisiable) {
		this.eqVisiable = eqVisiable;
	}
    public void setNeVisiable(Integer neVisiable) {
		this.neVisiable = neVisiable;
	}
    public void setEqDynamicNotice(Integer eqDynamicNotice) {
		this.eqDynamicNotice = eqDynamicNotice;
	}
    public void setNeDynamicNotice(Integer neDynamicNotice) {
		this.neDynamicNotice = neDynamicNotice;
	}
    public void setEqCommentApprove(Integer eqCommentApprove) {
		this.eqCommentApprove = eqCommentApprove;
	}
    public void setNeCommentApprove(Integer neCommentApprove) {
		this.neCommentApprove = neCommentApprove;
	}

}
