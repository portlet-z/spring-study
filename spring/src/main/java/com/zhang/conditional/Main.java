package com.zhang.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name") + "系统下的列表命令为：" + listService.showListCmd());
        System.out.println(context.getEnvironment().getProperty("os.name"));
    }
}
