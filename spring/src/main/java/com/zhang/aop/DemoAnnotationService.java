package com.zhang.aop;

import org.springframework.stereotype.Service;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Service
public class DemoAnnotationService {
    @Action(name = "注解拦截的add操作")
    public void add(){}
}
