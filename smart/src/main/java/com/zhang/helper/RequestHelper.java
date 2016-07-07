package com.zhang.helper;

import com.zhang.bean.FormParam;
import com.zhang.bean.Param;
import com.zhang.util.ArrayUtil;
import com.zhang.util.CodeUtil;
import com.zhang.util.StreamUtil;
import com.zhang.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 请求助手类
 * @author zhangxinzheng
 * @Date 2016/7/4
 */
public final class RequestHelper {
    /**
     * 创建请求对象
     */
    public static Param createParam(HttpServletRequest request) throws IOException{
        List<FormParam> formParamList = new ArrayList<FormParam>();
        formParamList.addAll(parseParameterNames(request));
        formParamList.addAll(parseInputStream(request));
        return new Param(formParamList);
    }
    private static List<FormParam> parseParameterNames(HttpServletRequest request){
        List<FormParam> formParamList = new ArrayList<FormParam>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String fieldName = paramNames.nextElement();
            String[] fieldValues = request.getParameterValues(fieldName);
            if(ArrayUtil.isEmpty(fieldValues)){
                continue;
            }
            Object fieldValue;
            if(fieldValues.length == 1){
                fieldValue = fieldValues[0];
            }else {
                StringBuilder sb = new StringBuilder("");
                for(int i=0; i<fieldValues.length; i++){
                    sb.append(fieldValues[i]);
                    if(i != fieldValues.length - 1){
                        sb.append(StringUtil.SEPARATOR);
                    }
                }
                fieldValue = sb.toString();
            }
            formParamList.add(new FormParam(fieldName,fieldValue));
        }
        return formParamList;
    }
    private static List<FormParam> parseInputStream(HttpServletRequest request) throws IOException{
        List<FormParam> formParamList = new ArrayList<FormParam>();
        String body = CodeUtil.decodeURL(StreamUtil.getString(request.getInputStream()));
        if(StringUtil.isEmpty(body)){
            return null;
        }
        String[] kvs = StringUtil.splitString(body, "$");
        if(ArrayUtil.isEmpty(kvs)){
            return null;
        }
        for(String kv:kvs){
            String[] array = StringUtil.splitString(kv,"=");
            if(ArrayUtil.isNotEmpty(array) && array.length == 2){
                String fieldName = array[0];
                String fieldValue = array[1];
                formParamList.add(new FormParam(fieldName,fieldValue));
            }
        }
        return formParamList;
    }
}
