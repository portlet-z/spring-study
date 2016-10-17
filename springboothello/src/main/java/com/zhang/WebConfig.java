package com.zhang;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhangxinzheng on 16/8/16.
 */
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/").allowedOrigins("http://www.xxx.com").allowedMethods("GET","POST");
    }
}
