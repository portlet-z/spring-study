package com.zhang.dao;

import com.zhang.model.User;

/**
 * @author zhangxinzheng
 * @Date 2016/4/20
 */
public interface UserDao {
    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);
}
