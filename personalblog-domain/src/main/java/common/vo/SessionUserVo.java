package common.vo;

import com.hfxt.domain.vo.BaseVo;


public class SessionUserVo extends BaseVo {
	private static final long serialVersionUID = -5900019539387305686L;
	private Long              id;
	private String            loginName;
	
	private String roleCode; //角色

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

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	
}
