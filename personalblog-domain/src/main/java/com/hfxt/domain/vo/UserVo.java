

package com.hfxt.domain.vo;

/**
 * @author:wanison
 * jdk-version:jdk1.7.0_67
 * createtime：2017-07-25
 */
public class UserVo extends BaseVo {

	private static final long serialVersionUID = 4678631912887673069L;
	
	private String rolename;
	private Integer amount;
	

	/** identifier field */

	private Integer userId;
    
	/** identifier field */

	private String accountEmail;
    
	/** identifier field */

	private String accountTel;
    
	/** identifier field */

	private String nickName;
    
	/** identifier field */

	private String password;
    
	/** identifier field */

	private Integer state;
	
	public static final Integer STATE_UNACTIVE = 0; //未激活
	public static final Integer STATE_ACTIVE = 1; //已激活
	public static final Integer STATE_BAN =2;  //禁止使用
    
	/** identifier field */

	private String headPortrait;
    
	/** identifier field */

	private Integer rate;
    
	/** identifier field */

	private Integer roleId;
    

	/**
	 * @return 返回 userId。
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId 要设置的 userId。
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return 返回 accountEmail。
	 */
	public String getAccountEmail() {
		return accountEmail;
	}

	/**
	 * @param accountEmail 要设置的 accountEmail。
	 */
	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	/**
	 * @return 返回 accountTel。
	 */
	public String getAccountTel() {
		return accountTel;
	}

	/**
	 * @param accountTel 要设置的 accountTel。
	 */
	public void setAccountTel(String accountTel) {
		this.accountTel = accountTel;
	}
	/**
	 * @return 返回 nickName。
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName 要设置的 nickName。
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return 返回 password。
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 要设置的 password。
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return 返回 state。
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * @param state 要设置的 state。
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return 返回 headPortrait。
	 */
	public String getHeadPortrait() {
		return headPortrait;
	}

	/**
	 * @param headPortrait 要设置的 headPortrait。
	 */
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	/**
	 * @return 返回 rate。
	 */
	public Integer getRate() {
		return rate;
	}

	/**
	 * @param rate 要设置的 rate。
	 */
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	/**
	 * @return 返回 roleId。
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId 要设置的 roleId。
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", accountEmail=" + accountEmail + ", accountTel=" + accountTel
				+ ", nickName=" + nickName + ", password=" + password + ", state=" + state + ", headPortrait="
				+ headPortrait + ", rate=" + rate + ", roleId=" + roleId + "]";
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
