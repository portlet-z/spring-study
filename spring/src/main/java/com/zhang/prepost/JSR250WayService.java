package com.zhang.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
public class JSR250WayService {
    @PostConstruct
    public void init(){
        System.out.println("jsr250-init-method");
    }

    public JSR250WayService() {
        super();
        System.out.println("初始化构造函数-JSR250WayService");
    }

    @PreDestroy
    public void destory(){
        System.out.println("jsr250-destroy-method");
    }
}
