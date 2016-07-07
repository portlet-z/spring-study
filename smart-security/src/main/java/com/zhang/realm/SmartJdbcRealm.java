package com.zhang.realm;

import com.zhang.SecurityConfig;
import com.zhang.helper.DatabaseHelper;
import com.zhang.password.Md5CredentialsMatch;
import org.apache.shiro.realm.jdbc.JdbcRealm;

/**
 * @author zhangxinzheng
 * @Date 2016/7/7
 */
public class SmartJdbcRealm extends JdbcRealm {
    public SmartJdbcRealm() {
        super.setDataSource(DatabaseHelper.getDataSource());
        super.setAuthenticationQuery(SecurityConfig.getJdbcAuthcQuery());
        super.setUserRolesQuery(SecurityConfig.getJdbcRolesQuery());
        super.setPermissionsQuery(SecurityConfig.getJdbcPermissionsQuery());
        super.setPermissionsLookupEnabled(true);
        super.setCredentialsMatcher(new Md5CredentialsMatch());
    }
}
