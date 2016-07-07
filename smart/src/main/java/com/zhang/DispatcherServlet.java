package com.zhang;

import com.zhang.bean.Data;
import com.zhang.bean.Handler;
import com.zhang.bean.Param;
import com.zhang.bean.View;
import com.zhang.helper.*;
import com.zhang.util.JsonUtil;
import com.zhang.util.ReflectionUtil;
import com.zhang.util.StringUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 请求转发器
 * @author zhangxinzheng
 * @Date 2016/7/4
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        HelperLoader.init();
        ServletContext servletContext = servletConfig.getServletContext();
        registerServlet(servletContext);
        UploadHelper.init(servletContext);
    }
    private void registerServlet(ServletContext servletContext){
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping("/index.jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping("/favicon.ico");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletHelper.init(request,response);
        try {
            String requestMethod = request.getMethod().toLowerCase();
            String requestPath = request.getPathInfo();
            Handler handler = ControllerHelper.getHandler(requestMethod,requestPath);
            if(null == handler){
                return;
            }
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            Param param;
            if(UploadHelper.isMultipart(request)){
                param = UploadHelper.createParam(request);
            }else {
                param = RequestHelper.createParam(request);
            }
            Object result;
            Method actionMethod = handler.getActionMethod();
            if(param.isEmpty()){
                result = ReflectionUtil.invokeMethod(controllerBean,actionMethod);
            }else {
                result = ReflectionUtil.invokeMethod(controllerBean,actionMethod,param);
            }
            if(result instanceof View){
                handleViewResult((View)result,request,response);
            }else if(result instanceof Data){
                handleDataResult((Data)result,response);
            }
        }finally {
            ServletHelper.destory();
        }
    }
    private void handleViewResult(View view,HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        String path = view.getPath();
        if(StringUtil.isEmpty(path)){
            return;
        }
        if(path.startsWith("/")){
            response.sendRedirect(request.getContextPath() + path);
        }else {
            Map<String,Object> model = view.getModel();
            for (Map.Entry<String,Object> entry : model.entrySet()){
                request.setAttribute(entry.getKey(),entry.getValue());
            }
            request.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(request,response);
        }
    }
    private void handleDataResult(Data data, HttpServletResponse response) throws IOException{
        Object model = data.getModel();
        if (null == model){
            return;
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        String json = JsonUtil.toJson(model);
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
