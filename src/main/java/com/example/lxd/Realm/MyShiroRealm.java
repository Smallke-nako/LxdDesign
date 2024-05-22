package com.example.lxd.Realm;


import com.example.lxd.entity.Users;
import com.example.lxd.service.UsersService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    UsersService usersService;
    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("doGetAuthorizationInfo=>进行了授权逻辑");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Users users = (Users) principalCollection.getPrimaryPrincipal();
        String rolePermission = "/admin";
        authorizationInfo.addStringPermission(rolePermission);
        return authorizationInfo;
    }
    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("doGetAuthenticationInfo=>进行了认证逻辑");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        Users users = usersService.getUsersByusername(userToken.getUsername());
        //盐值
        ByteSource credentialsSalt = null;
        if(users == null){
            return null;
        }else {
            credentialsSalt = ByteSource.Util.bytes(users.getSalt());
        }
        return new SimpleAuthenticationInfo(users.getUsername(), users.getPassword(),credentialsSalt,getName());

    }
}
