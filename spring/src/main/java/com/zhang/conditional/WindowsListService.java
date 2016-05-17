package com.zhang.conditional;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
public class WindowsListService implements ListService {
    public String showListCmd() {
        return "dir";
    }
}
