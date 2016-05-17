package com.zhang.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Configuration
@ComponentScan("com.zhang.taskscheduler")
@EnableScheduling
public class TaskShedulerConfig {
}
