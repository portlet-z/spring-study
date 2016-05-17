package com.zhang.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Service
public class UseFunctionService {
    @Autowired
    private FunctionService functionService;

    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}
