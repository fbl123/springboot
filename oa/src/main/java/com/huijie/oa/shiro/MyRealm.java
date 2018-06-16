package com.huijie.oa.shiro;

import com.huijie.oa.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalCollection) {
        principalCollection.getPrimaryPrincipal();//获取当先用户



        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        AuthenticationInfo info = null;
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;


        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());

        if (username == null) {
            throw new UnknownAccountException();
        } else if (password == null) {
            throw new IncorrectCredentialsException();
        } if (1 != 2) {
            throw new LockedAccountException();
        }


        info = new SimpleAuthenticationInfo(new User(), username, password);


        return info;
    }
}
