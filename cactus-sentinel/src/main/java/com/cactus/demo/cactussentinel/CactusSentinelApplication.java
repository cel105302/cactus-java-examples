package com.cactus.demo.cactussentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CactusSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(CactusSentinelApplication.class, args);
    }

    public void sentinelResource(){

    }

}
