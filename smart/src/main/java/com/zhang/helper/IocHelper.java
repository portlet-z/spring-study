package com.zhang.helper;

import com.zhang.annotation.Inject;
import com.zhang.util.ArrayUtil;
import com.zhang.util.CollectionUtil;
import com.zhang.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 * @author zhangxinzheng
 * @Date 2016/7/1
 */
public final class IocHelper {
    static {
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if(CollectionUtil.isNotEmpty(beanMap)){
            for(Map.Entry<Class<?>, Object> beanEntry:beanMap.entrySet()){
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getKey();
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtil.isEmpty(beanFields)){
                    continue;
                }
                for(Field beanField:beanFields){
                    if(!beanField.isAnnotationPresent(Inject.class)){
                        continue;
                    }
                    Class<?> beanFieldClass = beanField.getType();
                    Object beanFieldInstance = beanMap.get(beanFieldClass);
                    if(null == beanFieldInstance){
                        continue;
                    }
                    ReflectionUtil.setFiled(beanInstance,beanField,beanFieldInstance);
                }
            }
        }
    }
}
