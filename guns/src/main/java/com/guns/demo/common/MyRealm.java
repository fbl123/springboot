package com.guns.demo.common;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.*;

public class MyRealm extends AuthorizingRealm {

    /**
     * 存储角色与权限的方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        //获取当前登录对象
//        SysUser user= (SysUser) principalCollection.getPrimaryPrincipal();
//        //该对象拥有的角色
//        List<String> roles=Arrays.asList("admin");
//
//        //权限集合
//        List<String> permissionList = new ArrayList<>();
//
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        //设置当前用户拥有的角色（code）
//        simpleAuthorizationInfo.setRoles(new HashSet<String>(roles));
//        //设置当前用户拥有的权限(code)
//        simpleAuthorizationInfo.setStringPermissions(new HashSet<String>(permissionList));
//        return simpleAuthorizationInfo;
        return null;
    }

    /**
     * 登录认证的方法
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername(); //获取登录账号
        String password = new String(token.getPassword());  // 密码
        if ("admin".equals(userName) && "000000".equals(password)) {
            User user = new User();

            user.setName(userName);
            user.setPassword(password);
            //第一个参数 用户的信息
            //第二个参数 用户的密码
            return new SimpleAuthenticationInfo(user, "000000", getName());

        }
        return null;
    }
}
