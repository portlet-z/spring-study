package com.zhang.service.impl;

import com.zhang.dao.UserDao;
import com.zhang.model.User;
import com.zhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangxinzheng
 * @Date 2016/4/20
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
