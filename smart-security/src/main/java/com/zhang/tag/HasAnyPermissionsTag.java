package com.zhang.tag;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.PermissionTag;

/**
 * 判断当前用户是否拥有其中某一种权限
 * @author zhangxinzheng
 * @Date 2016/7/7
 */
public class HasAnyPermissionsTag extends PermissionTag {
    private static final String PERMISSION_NAMES_DELIMITER = ",";
    protected boolean showTagBody(String permissionNames) {
        boolean hasAnyPermission = false;
        Subject subject = getSubject();
        if(null != subject){
            for(String permissionName:permissionNames.split(PERMISSION_NAMES_DELIMITER)){
                if(subject.isPermitted(permissionName.trim())){
                    hasAnyPermission = true;
                    break;
                }
            }
        }
        return hasAnyPermission;
    }
}
