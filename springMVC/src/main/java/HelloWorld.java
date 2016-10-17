import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * Created by zhangxinzheng on 16/9/19.
 */
@BTrace
public class HelloWorld {
    @OnMethod(clazz = "cn.people.modules.cms.web.ArticleController", method = "list", location = @Location(Kind.RETURN))
    public static void testList(@Return String str){
        BTraceUtils.println("test list method" + str);
    }
}
