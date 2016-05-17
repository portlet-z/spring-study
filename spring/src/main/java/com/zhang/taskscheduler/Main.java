package com.zhang.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskShedulerConfig.class);

        System.out.println();
    }
}
