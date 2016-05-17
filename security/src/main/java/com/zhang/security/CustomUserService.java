package com.zhang.security;

import com.zhang.dao.SysUserRepository;
import com.zhang.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author zhangxinzheng
 * @Date 2016/5/11
 */
public class CustomUserService implements UserDetailsService {
    @Autowired
    private SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(username);
        return user;
    }
}
