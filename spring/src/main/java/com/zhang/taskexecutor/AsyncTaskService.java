package com.zhang.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Service
public class AsyncTaskService {
    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务：" + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1 " + i);
    }
}
