package com.lwl.project.admin.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 数据解密
 * @date 2019-11-30
 * @author lwl
 */
@Slf4j
@Aspect
@Component
public class DecryptAspact {

    @Pointcut(value = "@annotation(com.lwl.project.admin.annotation.Decrypt)")
    public void decryptPointCut() {
    }

    /**
     * 解密处理
     */
    @Before("decryptPointCut()")
    public void decryptData() {

    }
}
