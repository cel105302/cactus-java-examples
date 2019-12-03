package com.cactus.demo.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cactus.demo.sentinel.service.SentinelFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinel")
public class SentinelFlowController {
    @Autowired
    private SentinelFlowService sentinelFlowService;

    @RequestMapping("/urlFlow")
    public String urlFlow(){
        return sentinelFlowService.urlFlow();
    }
}
