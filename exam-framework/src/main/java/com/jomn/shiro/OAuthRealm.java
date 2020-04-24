package com.jomn.shiro;
import com.jomn.domain.SysUser;
import com.jomn.exception.user.UserNotExistsException;
import com.jomn.service.SysUserService;
import com.jomn.utlis.JWTUtil;
import com.jomn.utlis.PasswordHandler;
import com.jomn.utlis.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class OAuthRealm extends AuthorizingRealm {

    @Autowired
    SysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
      return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        String loginName =(String) authenticationToken.getPrincipal();
        SysUser user = null;
        try {
            user = sysUserService.login(loginName);
        }catch (UserNotExistsException e) {
            throw new UserNotExistsException();
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user.getLoginName(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName()
        );
        return simpleAuthenticationInfo;
    }



}
