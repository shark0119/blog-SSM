
package com.hfxt.domain.search;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class MessageSearch extends BaseSearch {

	private static final long serialVersionUID = -852982973049038098L;
	/**
     *MessageId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqMessageId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neMessageId;
    /**
     *SenderId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqSenderId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neSenderId;
    /**
     *ReceiverId(10,0)
	 * dbValue == thisValue
	 */
    private Integer eqReceiverId;
     /**
	 * dbValue <> thisValue
	 */
    private Integer neReceiverId;
    /**
     * Content(600)
	 * dbValue == thisValue
	 */
    private String eqContent;
    /**
	 * dbValue like %thisValue%
	 */
    private String lkContent;
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

    
    public Integer getEqMessageId() {
        return eqMessageId;
    }
    public Integer getNeMessageId() {
        return neMessageId;
    }
    
    public Integer getEqSenderId() {
        return eqSenderId;
    }
    public Integer getNeSenderId() {
        return neSenderId;
    }
    
    public Integer getEqReceiverId() {
        return eqReceiverId;
    }
    public Integer getNeReceiverId() {
        return neReceiverId;
    }
    
    public String getEqContent() {
        return eqContent;
    }
    public String getLkContent() {
        return lkContent;
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
    public void setEqMessageId(Integer eqMessageId) {
		this.eqMessageId = eqMessageId;
	}
    public void setNeMessageId(Integer neMessageId) {
		this.neMessageId = neMessageId;
	}
    public void setEqSenderId(Integer eqSenderId) {
		this.eqSenderId = eqSenderId;
	}
    public void setNeSenderId(Integer neSenderId) {
		this.neSenderId = neSenderId;
	}
    public void setEqReceiverId(Integer eqReceiverId) {
		this.eqReceiverId = eqReceiverId;
	}
    public void setNeReceiverId(Integer neReceiverId) {
		this.neReceiverId = neReceiverId;
	}

	public void setEqContent(String eqContent) {
		this.eqContent = eqContent;
	}
    public void setLkContent(String lkContent) {
		this.lkContent = lkContent;
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

}
