package com.zhang.exception;

/**
 * 认证异常（当非法访问时抛出）
 * @author zhangxinzheng
 * @Date 2016/7/7
 */
public class AuthcException extends Exception{
    public AuthcException() {
        super();
    }

    public AuthcException(String message) {
        super(message);
    }

    public AuthcException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthcException(Throwable cause) {
        super(cause);
    }
}
