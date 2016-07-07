package com.zhang.tag;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.PermissionTag;

/**
 * 判断当前用户是否拥有其中所有的权限（逗号分隔，表示与的关系）
 * @author zhangxinzheng
 * @Date 2016/7/7
 */
public class HasAllPermissionsTag extends PermissionTag{
    private static String PERMISSION_NAMES_DELIMITER = ",";
    protected boolean showTagBody(String permNames) {
        boolean hasAllPermission = false;
        Subject subject = getSubject();
        if(null != subject){
            if(subject.isPermittedAll(permNames.split(PERMISSION_NAMES_DELIMITER))){
                hasAllPermission = true;
            }
        }
        return hasAllPermission;
    }
}
