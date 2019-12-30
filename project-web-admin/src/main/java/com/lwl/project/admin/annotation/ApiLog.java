package com.lwl.project.admin.annotation;

import java.lang.annotation.*;

/**
 * Api日志注解 注解在接口方法上，记录请求信息日志
 * @date 2019-11-28
 * @author lwl
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiLog {
}
