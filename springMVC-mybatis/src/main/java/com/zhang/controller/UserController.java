package com.zhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangxinzheng
 * @Date 2016/4/20
 */
@Controller
@RequestMapping("/")
public class UserController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
