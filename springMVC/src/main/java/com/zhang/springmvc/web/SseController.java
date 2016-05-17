package com.zhang.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @author zhangxinzheng
 * @Date 2016/5/9
 */
@Controller
public class SseController {
    @RequestMapping(value = "/push", produces = "text/event-stream")
    public @ResponseBody String push(){
        Random r = new Random();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + r.nextInt() + "\n\n";
    }
}
