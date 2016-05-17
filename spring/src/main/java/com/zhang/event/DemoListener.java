package com.zhang.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("我(bean-demoListener)收到了bean-demoPublisher发布的消息：" + msg);
    }
}
