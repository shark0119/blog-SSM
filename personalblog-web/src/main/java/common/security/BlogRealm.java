package common.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hfxt.domain.vo.UserVo;
import com.hfxt.service.IUserService;

public class BlogRealm extends AuthorizingRealm {

	private static Logger logger = LoggerFactory.getLogger(BlogRealm.class); 
	
	@Autowired
	private IUserService userService ;
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName=(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		String role = userService.getRoleByName(userName);
		logger.info("获取的角色为：" + role);
		authorizationInfo.addRole(role);
		return authorizationInfo;
	}
	
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=(String)token.getPrincipal();
		UserVo user = null;
		try{
			user=userService.getUserByName (userName);
		} catch (Exception e){
			e.printStackTrace();
		}
		if(user!=null){
			logger.info("已从数据库查询到用户实体，开始认证");
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(userName,user.getPassword(),getName());
			return authcInfo;
		}else{
			logger.info("无此用户");
			throw new UnknownAccountException();
		}
	}

}
