package com.zhang.prepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Configuration
@ComponentScan("com.zhang.prepost")
public class PrePostConfig {
    @Bean(initMethod = "init", destroyMethod = "destory")
    BeanWayService beanWayService(){
        return new BeanWayService();
    }

    @Bean
    JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }
}
