package com.zhang.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Configuration
@ComponentScan("com.zhang.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
