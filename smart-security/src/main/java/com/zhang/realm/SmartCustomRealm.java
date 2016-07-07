package com.zhang.realm;

import com.zhang.SecurityConstant;
import com.zhang.SmartSecurity;
import com.zhang.password.Md5CredentialsMatch;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * 基于Smart的自定义Realm(需要实现SmartSecurity接口)
 * @author zhangxinzheng
 * @Date 2016/7/7
 */
public class SmartCustomRealm extends AuthorizingRealm{
    private final SmartSecurity smartSecurity;

    public SmartCustomRealm(SmartSecurity smartSecurity) {
        this.smartSecurity = smartSecurity;
        super.setName(SecurityConstant.REALMS_CUSTOM);
        super.setCredentialsMatcher(new Md5CredentialsMatch());
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if(null == token){
            throw new AuthenticationException("parameter token is null");
        }
        String username = ((UsernamePasswordToken)token).getUsername();
        String password = smartSecurity.getPassword(username);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        authenticationInfo.setPrincipals(new SimplePrincipalCollection(username,super.getName()));
        authenticationInfo.setCredentials(password);
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if(null == principals){
            throw new AuthenticationException("parameter principals is null");
        }
        String username = super.getAvailablePrincipal(principals).toString();
        Set<String> roleNameSet = smartSecurity.getRoleNameSet(username);
        Set<String> permissionNameSet = new HashSet<String>();
        if(roleNameSet != null && roleNameSet.size() > 0){
            for (String roleName:roleNameSet){
                Set<String> currentPermissionNameSet = smartSecurity.getPermissionNameSet(roleName);
                permissionNameSet.addAll(currentPermissionNameSet);
            }
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleNameSet);
        authorizationInfo.setStringPermissions(permissionNameSet);
        return authorizationInfo;
    }
}
