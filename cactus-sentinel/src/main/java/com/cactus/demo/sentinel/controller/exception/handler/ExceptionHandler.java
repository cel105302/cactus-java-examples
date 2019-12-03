package com.cactus.demo.sentinel.controller.exception.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public JSONObject apiExceptionHandler(Exception e){
        JSONObject res = new JSONObject();
        res.put("fail", "-9999");
        return res;
    }
}
