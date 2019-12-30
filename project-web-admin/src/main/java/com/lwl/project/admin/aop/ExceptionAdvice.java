package com.lwl.project.admin.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = "com.lwl.project.admin.controller")
public class ExceptionAdvice {

    public static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
       Map<String, Object> map = new HashMap<>();
       map.put("error", "parameter error");
       map.put("message", "请求参数不能为空");
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity handleHttpMessageNotReadableException(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", "server error");
        map.put("message", "服务出错了");
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
    }
}




