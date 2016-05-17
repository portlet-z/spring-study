package com.zhang.springmvc.web;

import com.zhang.springmvc.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangxinzheng
 * @Date 2016/5/9
 */
public class ConverterController {
    @RequestMapping(value = "/convert", produces = {"application/x-wisely"})
    public @ResponseBody DemoObj convert(@RequestBody DemoObj demoObj){
        return demoObj;
    }
}
