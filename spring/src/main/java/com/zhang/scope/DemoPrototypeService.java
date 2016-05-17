package com.zhang.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author zhangxinzheng
 * @Date 2016/5/6
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {
}
