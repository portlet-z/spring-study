package com.zhang.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
public class DemoEvent extends ApplicationEvent{
    private static final long serialVerisonUID = 1l;
    private String msg;

    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
