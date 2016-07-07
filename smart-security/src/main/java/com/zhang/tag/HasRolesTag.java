package com.zhang.tag;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.RoleTag;

import java.util.Arrays;

/**
 * 判断当前用户是否拥有其中所有的角色（逗号分隔，表示与的关系）
 * @author zhangxinzheng
 * @Date 2016/7/7
 */
public class HasRolesTag extends RoleTag {
    private static final String ROLE_NAMES_DELIMITER = ",";
    protected boolean showTagBody(String s) {
        boolean hasAllRole = false;
        Subject subject = getSubject();
        if(null != subject){
            if(subject.hasAllRoles(Arrays.asList(s.split(ROLE_NAMES_DELIMITER)))){
                hasAllRole = true;
            }
        }
        return hasAllRole;
    }
}
