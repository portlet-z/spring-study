package com.zhang.conditional;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
public class LinuxListService implements ListService {
    public String showListCmd() {
        return "ls";
    }
}
