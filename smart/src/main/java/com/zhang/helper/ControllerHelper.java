package com.zhang.helper;

import com.zhang.annotation.Action;
import com.zhang.bean.Handler;
import com.zhang.bean.Request;
import com.zhang.util.ArrayUtil;
import com.zhang.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器助手类
 * @author zhangxinzheng
 * @Date 2016/7/1
 */
public final class ControllerHelper {
    private static final Map<Request,Handler> ACTION_MAP = new HashMap<Request, Handler>();
    static {
        Set<Class<?>> controllerClassSet = ClassHepler.getControllerClassSet();
        if(CollectionUtil.isNotEmpty(controllerClassSet)){
            for(Class<?> controllerClass:controllerClassSet){
                Method[] methods = controllerClass.getDeclaredMethods();
                if(ArrayUtil.isEmpty(methods)){
                    continue;
                }
                for (Method method:methods){
                    if(method.isAnnotationPresent(Action.class)){
                        Action action = method.getAnnotation(Action.class);
                        String mapping = action.value();
                        if(!mapping.matches("\\w+:/\\w*")){
                            continue;
                        }
                        String[] array = mapping.split(":");
                        if(ArrayUtil.isNotEmpty(array) && array.length == 2){
                            String requestMethod = array[0];
                            String requestPath = array[1];
                            Request request = new Request(requestMethod,requestPath);
                            Handler handler = new Handler(controllerClass,method);
                            ACTION_MAP.put(request,handler);
                        }
                    }
                }
            }
        }
    }
    /**
     * 获取Handler
     */
    public static Handler getHandler(String requestMethod,String requestPath){
        Request request = new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
    }
}
