
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class UserSearch extends BaseSearch {

	private static final long serialVersionUID = 8669722840942119911L;
	/**
     *UserId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqUserId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neUserId;
    /**
     * accountEmail(60)
	 * dbValue == thisValue
	 */
    private String eqAccountEmail;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkAccountEmail;
    /**
     * accountTel(60)
	 * dbValue == thisValue
	 */
    private String eqAccountTel;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkAccountTel;
    /**
     * nickName(60)
	 * dbValue == thisValue
	 */
    private String eqNickName;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkNickName;
    /**
     * password(120)
	 * dbValue == thisValue
	 */
    private String eqPassword;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkPassword;
    /**
     *state(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqState;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neState;
    /**
     * headPortrait(765)
	 * dbValue == thisValue
	 */
    private String eqHeadPortrait;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkHeadPortrait;
    /**
     *rate(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqRate;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neRate;
    /**
     *roleId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqRoleId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neRoleId;

    
    public Integer getEqUserId() {
        return eqUserId;
    }
    public Integer getNeUserId() {
        return neUserId;
    }
    
    public String getEqAccountEmail() {
        return eqAccountEmail;
    }
    public String getLkAccountEmail() {
        return lkAccountEmail;
    }
    
    public String getEqAccountTel() {
        return eqAccountTel;
    }
    public String getLkAccountTel() {
        return lkAccountTel;
    }
    
    public String getEqNickName() {
        return eqNickName;
    }
    public String getLkNickName() {
        return lkNickName;
    }
    
    public String getEqPassword() {
        return eqPassword;
    }
    public String getLkPassword() {
        return lkPassword;
    }
    
    public Integer getEqState() {
        return eqState;
    }
    public Integer getNeState() {
        return neState;
    }
    
    public String getEqHeadPortrait() {
        return eqHeadPortrait;
    }
    public String getLkHeadPortrait() {
        return lkHeadPortrait;
    }
    
    public Integer getEqRate() {
        return eqRate;
    }
    public Integer getNeRate() {
        return neRate;
    }
    
    public Integer getEqRoleId() {
        return eqRoleId;
    }
    public Integer getNeRoleId() {
        return neRoleId;
    }
    public void setEqUserId(Integer eqUserId) {
		this.eqUserId = eqUserId;
	}
    public void setNeUserId(Integer neUserId) {
		this.neUserId = neUserId;
	}

	public void setEqAccountEmail(String eqAccountEmail) {
		this.eqAccountEmail = eqAccountEmail;
	}
    public void setLkAccountEmail(String lkAccountEmail) {
		this.lkAccountEmail = lkAccountEmail;
	}

	public void setEqAccountTel(String eqAccountTel) {
		this.eqAccountTel = eqAccountTel;
	}
    public void setLkAccountTel(String lkAccountTel) {
		this.lkAccountTel = lkAccountTel;
	}

	public void setEqNickName(String eqNickName) {
		this.eqNickName = eqNickName;
	}
    public void setLkNickName(String lkNickName) {
		this.lkNickName = lkNickName;
	}

	public void setEqPassword(String eqPassword) {
		this.eqPassword = eqPassword;
	}
    public void setLkPassword(String lkPassword) {
		this.lkPassword = lkPassword;
	}
    public void setEqState(Integer eqState) {
		this.eqState = eqState;
	}
    public void setNeState(Integer neState) {
		this.neState = neState;
	}

	public void setEqHeadPortrait(String eqHeadPortrait) {
		this.eqHeadPortrait = eqHeadPortrait;
	}
    public void setLkHeadPortrait(String lkHeadPortrait) {
		this.lkHeadPortrait = lkHeadPortrait;
	}
    public void setEqRate(Integer eqRate) {
		this.eqRate = eqRate;
	}
    public void setNeRate(Integer neRate) {
		this.neRate = neRate;
	}
    public void setEqRoleId(Integer eqRoleId) {
		this.eqRoleId = eqRoleId;
	}
    public void setNeRoleId(Integer neRoleId) {
		this.neRoleId = neRoleId;
	}

}
