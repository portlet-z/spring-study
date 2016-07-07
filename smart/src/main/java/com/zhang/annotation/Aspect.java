package com.zhang.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * @author zhangxinzheng
 * @Date 2016/7/1
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
