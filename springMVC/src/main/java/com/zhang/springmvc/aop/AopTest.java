package com.zhang.springmvc.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangxinzheng on 16/8/1.
 */
public class AopTest {
    @org.junit.Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        Test test = (Test) ctx.getBean("test");
         test.example();
    }
}
