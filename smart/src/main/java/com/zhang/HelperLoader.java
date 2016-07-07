package com.zhang;

import com.zhang.helper.*;
import com.zhang.util.ClassUtil;

/**
 * 加载相应的Helper类
 * @author zhangxinzheng
 * @Date 2016/7/4
 */
public final class HelperLoader {
    public static void init(){
        Class<?>[] classList = {ClassHepler.class, BeanHelper.class, AopHelper.class, IocHelper.class, ControllerHelper.class};
        for (Class<?> cls:classList){
            ClassUtil.loadClass(cls.getName());
        }
    }
}
