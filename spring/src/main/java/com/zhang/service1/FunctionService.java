package com.zhang.service1;

import org.springframework.stereotype.Service;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Service
public class FunctionService {
    public String sayHello(String word){
        return "hello " + word + " !";
    }
}
