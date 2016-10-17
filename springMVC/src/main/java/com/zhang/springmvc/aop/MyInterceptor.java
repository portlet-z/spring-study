package com.zhang.springmvc.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zhangxinzheng on 16/8/1.
 */
@Aspect
public class MyInterceptor {
    @Pointcut("execution(* com.zhang.springmvc.aop.Test.*(..))")
    private void point(){

    }
    @Before("point()")
    public void before(){
        System.out.println("before()");
    }
    @After("point()")
    public void after(){
        System.out.println("after()");
    }
    Map<String, String> map = new TreeMap<String, String>(new Comparator<String>() {
        public int compare(String obj1, String obj2) {
            return obj2.compareTo(obj1);//降序排序
        }
    });
}
