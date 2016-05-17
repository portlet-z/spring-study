package com.zhang.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime(){
        System.out.println("每隔1秒执行一次 " + DATE_FORMAT.format(new Date()));
    }

}
