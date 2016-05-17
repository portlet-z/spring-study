package com.zhang.dao;

import com.zhang.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangxinzheng
 * @Date 2016/5/11
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
