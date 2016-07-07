package com.zhang.exception;

/**
 * 授权异常（当权限无效时抛出）
 * @author zhangxinzheng
 * @Date 2016/7/7
 */
public class AuthzException extends RuntimeException {
    public AuthzException() {
        super();
    }

    public AuthzException(String message) {
        super(message);
    }

    public AuthzException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthzException(Throwable cause) {
        super(cause);
    }
}
