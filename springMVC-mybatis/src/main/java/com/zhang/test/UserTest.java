package com.zhang.test;

import com.zhang.model.User;
import com.zhang.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangxinzheng
 * @Date 2016/4/20
 */
public class UserTest {
    private UserService userService;

    @Before
    public void before() {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
                , "classpath:conf/spring-mybatis.xml"});
        userService = (UserService) context.getBean("userServiceImpl");
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setAge(22);
        user.setGender("男");
        user.setName("张三");
        user.setRemark("学生");
        System.out.println(userService.insertUser(user));
    }
}
