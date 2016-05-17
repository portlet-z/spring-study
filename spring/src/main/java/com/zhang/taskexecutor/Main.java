package com.zhang.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutor.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
        for(int i=0; i<10; i++){
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();
        System.out.println();
    }
}
