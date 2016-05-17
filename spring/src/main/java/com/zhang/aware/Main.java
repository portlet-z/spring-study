package com.zhang.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();
        context.close();
        System.out.println();
    }
}
