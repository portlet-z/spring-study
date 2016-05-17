package com.zhang.annotation;

import org.springframework.stereotype.Service;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Service
public class DemoService {
    public void outputResult(){
        System.out.println("从组合注解配置照样获得的bean");
    }
}
