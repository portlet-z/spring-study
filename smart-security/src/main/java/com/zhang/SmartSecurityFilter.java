package com.zhang;

import com.zhang.realm.SmartCustomRealm;
import com.zhang.realm.SmartJdbcRealm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.CachingSecurityManager;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 安全过滤器
 * @author zhangxinzheng
 * @Date 2016/7/7
 */
public class SmartSecurityFilter extends ShiroFilter{
    @Override
    public void init() throws Exception {
        super.init();
        WebSecurityManager webSecurityManager = super.getSecurityManager();
        setRealms(webSecurityManager);
        setCache(webSecurityManager);
    }
    private void setRealms(WebSecurityManager webSecurityManager){
        String securityRealms = SecurityConfig.getRealms();
        if(null == securityRealms){
            return;
        }
        String[] securityRealmArray = securityRealms.split(",");
        if(securityRealmArray.length < 1){
            return;
        }
        Set<Realm> realms = new LinkedHashSet<Realm>();
        for(String securityRealm:securityRealmArray){
            if(securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_JDBC)){
                addJdbcRealm(realms);
            }else if(securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_CUSTOM)){
                addCustomRealm(realms);
            }
        }
        RealmSecurityManager realmSecurityManager = (RealmSecurityManager)webSecurityManager;
        realmSecurityManager.setRealms(realms);
    }
    private void addJdbcRealm(Set<Realm> realms){
        SmartJdbcRealm smartJdbcRealm = new SmartJdbcRealm();
        realms.add(smartJdbcRealm);
    }
    private void addCustomRealm(Set<Realm> realms){
        SmartSecurity smartSecurity = SecurityConfig.getSmartSecurity();
        SmartCustomRealm smartCustomRealm = new SmartCustomRealm(smartSecurity);
        realms.add(smartCustomRealm);
    }
    private void setCache(WebSecurityManager webSecurityManager){
        if(SecurityConfig.isCache()){
            CachingSecurityManager cachingSecurityManager = (CachingSecurityManager)webSecurityManager;
            CacheManager cacheManager = new MemoryConstrainedCacheManager();
            cachingSecurityManager.setCacheManager(cacheManager);
        }
    }
}
