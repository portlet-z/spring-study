package com.zhang.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
public class UseFunctionService {
    private FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}
