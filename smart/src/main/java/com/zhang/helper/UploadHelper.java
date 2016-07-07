package com.zhang.helper;

import com.zhang.bean.FileParam;
import com.zhang.bean.FormParam;
import com.zhang.bean.Param;
import com.zhang.util.CollectionUtil;
import com.zhang.util.FileUtil;
import com.zhang.util.StreamUtil;
import com.zhang.util.StringUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 文件上传助手类
 * @author zhangxinzheng
 * @Date 2016/7/4
 */
public final class UploadHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadHelper.class);
    private static ServletFileUpload servletFileUpload;
    /**
     * 初始化
     */
    public static void init(ServletContext servletContext){
        File repository = (File)servletContext.getAttribute("javax.servlet.context.tempdir");
        servletFileUpload = new ServletFileUpload(new DiskFileItemFactory(DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD,repository));
        int uploadLimit = ConfigHelper.getAppUploadLimit();
        if(uploadLimit != 0){
            servletFileUpload.setFileSizeMax(uploadLimit * 1024 * 1024);
        }
    }
    /**
     * 判断请求是否为multipart类型
     */
    public static boolean isMultipart(HttpServletRequest request){
        return ServletFileUpload.isMultipartContent(request);
    }
    /**
     * 创建请求对象
     */
    public static Param createParam(HttpServletRequest request) throws IOException{
        List<FormParam> formParamList = new ArrayList<FormParam>();
        List<FileParam> fileParamList = new ArrayList<FileParam>();
        try {
            Map<String,List<FileItem>> fileItemListMap = servletFileUpload.parseParameterMap(request);
            if(CollectionUtil.isEmpty(fileItemListMap)){
                return null;
            }
            for(Map.Entry<String,List<FileItem>> fileItemListEntry:fileItemListMap.entrySet()){
                String filedName = fileItemListEntry.getKey();
                List<FileItem> fileItemList = fileItemListEntry.getValue();
                if(CollectionUtil.isEmpty(fileItemList)){
                    continue;
                }
                for(FileItem fileItem:fileItemList){
                    if(fileItem.isFormField()){
                        String fieldValue = fileItem.getString("UTF-8");
                        formParamList.add(new FormParam(filedName,fieldValue));
                    }else {
                        String fileName = FileUtil.getRealFileName(new String(fileItem.getName().getBytes(),"UTF-8"));
                        if(StringUtil.isEmpty(filedName)){
                            continue;
                        }
                        long fileSize = fileItem.getSize();
                        String contentType = fileItem.getContentType();
                        InputStream inputStream = fileItem.getInputStream();
                        fileParamList.add(new FileParam(filedName,fileName,fileSize,contentType,inputStream));
                    }
                }
            }
        }catch (FileUploadException e){
            LOGGER.error("create param failure",e);
            throw new RuntimeException(e);
        }
        return new Param(formParamList,fileParamList);
    }
    /**
     * 上传文件
     */
    public static void uploadFile(String basePath,FileParam fileParam){
        try {
            if(null == fileParam){
                return;
            }
            String filePath = basePath + fileParam.getFileName();
            FileUtil.createFile(filePath);
            InputStream inputStream = new BufferedInputStream(fileParam.getInputStream());
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
            StreamUtil.copyStream(inputStream,outputStream);
        }catch (Exception e){
            LOGGER.error("upload file failure",e);
            throw new RuntimeException(e);
        }
    }
    /**
     * 批量上传文件
     */
    public static void uploadFile(String basePath,List<FileParam> fileParamList){
        try {
            if(CollectionUtil.isEmpty(fileParamList)){
                return;
            }
            for(FileParam fileParam:fileParamList){
                uploadFile(basePath, fileParam);
            }
        }catch (Exception e){
            LOGGER.error("upload file failure",e);
            throw new RuntimeException(e);
        }
    }
}
