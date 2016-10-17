package com.zhang.springmvc.aop;

import org.springframework.transaction.annotation.Transactional;

/** * Created by zhangxinzheng on 16/8/1.
 */
@Transactional
public class Test {
    public void example(){
        System.out.println("example");
    }
}
