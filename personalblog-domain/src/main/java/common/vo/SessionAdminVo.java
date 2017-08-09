package common.vo;

import com.hfxt.domain.vo.BaseVo;

public class SessionAdminVo extends BaseVo {

	private static final long serialVersionUID = -7992120981147070761L;
	
	private Long              id;
	private String            loginName;
	private String            nickName;
	/*
	private String            loginEmail;

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}
	*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
