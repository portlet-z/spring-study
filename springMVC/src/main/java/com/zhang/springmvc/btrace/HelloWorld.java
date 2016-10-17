package com.zhang.springmvc.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;

/**
 * Created by zhangxinzheng on 16/9/19.
 */
@BTrace
public class HelloWorld {
    @OnMethod(clazz = "cn.people.modules.cms.web.ArticleController", method = "list")
    public static void testList(){
        BTraceUtils.println("test list method");
    }
}
