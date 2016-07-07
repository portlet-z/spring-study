package com.zhang.rest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * REST服务注解
 * @author zhangxinzheng
 * @Date 2016/7/7
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Rest {
    /**
     * 服务名
     */
    String value() default "";
}
