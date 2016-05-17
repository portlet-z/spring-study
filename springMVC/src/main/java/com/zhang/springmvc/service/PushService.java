package com.zhang.springmvc.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author zhangxinzheng
 * @Date 2016/5/9
 */
@Service
public class PushService {
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsyncUpdate(){
        deferredResult = new DeferredResult<String>();
        return deferredResult;
    }

    @Scheduled(fixedRate = 2000)
    public void refresh(){
        if(null != deferredResult){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
