package com.zhang.springmvc.web;

import com.zhang.springmvc.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author zhangxinzheng
 * @Date 2016/5/9
 */
@Controller
public class AsyncController {
    @Autowired
    private PushService pushService;

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredResult(){
        return pushService.getAsyncUpdate();
    }
}
