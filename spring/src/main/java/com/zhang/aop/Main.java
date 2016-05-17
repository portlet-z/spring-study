package com.zhang.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoAnnotationService.add();
        demoMethodService.add();;
        context.close();
    }
}
