package com.cactus.demo.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

public class BlockHandler {

    public static String handleException(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException exception) {
        System.out.println("hahaha bei lan jie le");
        return "hahahha";
    }
}
