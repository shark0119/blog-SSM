
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class TrightSearch extends BaseSearch {

	private static final long serialVersionUID = 3774869160505556104L;
	/**
     * tightid(60)
	 * dbValue == thisValue
	 */
    private String eqTightid;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkTightid;
    /**
     * rightparentcode(60)
	 * dbValue == thisValue
	 */
    private String eqRightparentcode;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkRightparentcode;
    /**
     * righttitle(60)
	 * dbValue == thisValue
	 */
    private String eqRighttitle;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkRighttitle;
    /**
     * righturl(150)
	 * dbValue == thisValue
	 */
    private String eqRighturl;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkRighturl;

    
    public String getEqTightid() {
        return eqTightid;
    }
    public String getLkTightid() {
        return lkTightid;
    }
    
    public String getEqRightparentcode() {
        return eqRightparentcode;
    }
    public String getLkRightparentcode() {
        return lkRightparentcode;
    }
    
    public String getEqRighttitle() {
        return eqRighttitle;
    }
    public String getLkRighttitle() {
        return lkRighttitle;
    }
    
    public String getEqRighturl() {
        return eqRighturl;
    }
    public String getLkRighturl() {
        return lkRighturl;
    }

	public void setEqTightid(String eqTightid) {
		this.eqTightid = eqTightid;
	}
    public void setLkTightid(String lkTightid) {
		this.lkTightid = lkTightid;
	}

	public void setEqRightparentcode(String eqRightparentcode) {
		this.eqRightparentcode = eqRightparentcode;
	}
    public void setLkRightparentcode(String lkRightparentcode) {
		this.lkRightparentcode = lkRightparentcode;
	}

	public void setEqRighttitle(String eqRighttitle) {
		this.eqRighttitle = eqRighttitle;
	}
    public void setLkRighttitle(String lkRighttitle) {
		this.lkRighttitle = lkRighttitle;
	}

	public void setEqRighturl(String eqRighturl) {
		this.eqRighturl = eqRighturl;
	}
    public void setLkRighturl(String lkRighturl) {
		this.lkRighturl = lkRighturl;
	}

}
