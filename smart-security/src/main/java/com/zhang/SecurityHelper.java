package com.zhang;

import com.zhang.exception.AuthcException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Security助手类
 * @author zhangxinzheng
 * @Date 2016/7/7
 */
public final class SecurityHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityHelper.class);
    /**
     * 登录
     */
    public static void login(String username,String password)throws AuthcException{
        Subject currentUser = SecurityUtils.getSubject();
        if(null == currentUser){
            return;
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        currentUser.login(token);
    }
    /**
     * 注销
     */
    public static void logout(){
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){
            currentUser.logout();
        }
    }
}
