package com.zhang.password;

import com.zhang.util.CodeUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * @author zhangxinzheng
 * @Date 2016/7/7
 */
public class Md5CredentialsMatch implements CredentialsMatcher {
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        String submitted = String.valueOf(((UsernamePasswordToken)authenticationToken).getPassword());
        String encrypted = String.valueOf(authenticationInfo.getCredentials());
        return CodeUtil.md5(submitted).endsWith(encrypted);
    }
}
