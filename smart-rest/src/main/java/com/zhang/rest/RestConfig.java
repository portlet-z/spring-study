package com.zhang.rest;

import com.zhang.helper.ConfigHelper;
import com.zhang.util.StringUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 从配置文件中获取相关属性
 * @author zhangxinzheng
 * @Date 2016/7/7
 */
public class RestConfig {
    public static boolean isLog(){
        return ConfigHelper.getBoolean(RestConstant.LOG);
    }
    public static boolean isJsonp(){
        return ConfigHelper.getBoolean(RestConstant.JSONP);
    }
    public static String getJsonpFunction(){
        return ConfigHelper.getString(RestConstant.JSONP_FUNCTION);
    }
    public static boolean isCors(){
        return ConfigHelper.getBoolean(RestConstant.CORS);
    }
    public static List<String> getCorsOriginList(){
        String corsOrigin = ConfigHelper.getString(RestConstant.CORS_ORIGIN);
        return Arrays.asList(StringUtil.splitString(corsOrigin,","));
    }
}
