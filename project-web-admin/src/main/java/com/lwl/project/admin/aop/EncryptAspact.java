package com.lwl.project.admin.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 数据加密
 * @date 2019-11-30
 * @author lwl
 */
@Slf4j
@Aspect
@Component
public class EncryptAspact {

    @Pointcut(value = "@annotation(com.lwl.project.admin.annotation.Encrypt)")
    public void encryptPointCut() {
    }

    /**
     * 加密处理
     */
    @AfterReturning("encryptPointCut()")
    public void encryptData() {

    }
}
