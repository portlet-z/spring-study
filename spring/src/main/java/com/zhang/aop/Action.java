package com.zhang.aop;

import java.lang.annotation.*;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
