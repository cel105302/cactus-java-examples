package com.cactus.demo.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cactus.demo.sentinel.handler.BlockHandler;
import org.springframework.stereotype.Service;

@Service
public class SentinelFlowService {

    @SentinelResource(value = "sentinelFlow", blockHandler = "handleException", blockHandlerClass = {BlockHandler.class})
    public String urlFlow(){
        return "urlFlow";
    }
}
