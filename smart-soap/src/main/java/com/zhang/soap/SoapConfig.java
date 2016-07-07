package com.zhang.soap;

import com.zhang.helper.ConfigHelper;

/**
 * 从配置文件中获取相关属性
 * @author zhangxinzheng
 * @Date 2016/7/7
 */
public class SoapConfig {
    public static boolean isLog(){
        return ConfigHelper.getBoolean(SoapConstant.LOG);
    }
}
