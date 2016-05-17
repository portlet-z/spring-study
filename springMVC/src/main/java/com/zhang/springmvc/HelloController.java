package com.zhang.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Controller
public class HelloController {
    @RequestMapping("/index")
    public String hello(){
        return "index";
    }
}
