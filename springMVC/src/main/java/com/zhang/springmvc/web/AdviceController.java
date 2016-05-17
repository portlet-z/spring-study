package com.zhang.springmvc.web;

import com.zhang.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Controller
public class AdviceController {
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj){
        throw new IllegalStateException("非常抱歉，参数有误/来自@ModelAttribute:" + msg);
    }
}
