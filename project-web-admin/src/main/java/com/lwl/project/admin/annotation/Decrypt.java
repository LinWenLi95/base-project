package com.lwl.project.admin.annotation;

import java.lang.annotation.*;

/**
 * 请求数据解密
 * @date 2019-11-30
 * @author lwl
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Decrypt {
}
