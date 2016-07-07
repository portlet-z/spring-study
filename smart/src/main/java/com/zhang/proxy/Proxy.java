package com.zhang.proxy;

/**
 * 代理接口
 * @author zhangxinzheng
 * @Date 2016/7/1
 */
public interface Proxy {
    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
