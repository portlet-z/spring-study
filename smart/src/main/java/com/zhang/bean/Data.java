package com.zhang.bean;

/**
 * 返回数据对象
 * @author zhangxinzheng
 * @Date 2016/7/1
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
