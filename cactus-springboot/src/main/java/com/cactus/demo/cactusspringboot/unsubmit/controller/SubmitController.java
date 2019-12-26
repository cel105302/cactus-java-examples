package com.cactus.demo.cactusspringboot.unsubmit.controller;

import com.cactus.demo.cactusspringboot.unsubmit.UnsubmitEnumeration;
import com.cactus.demo.cactusspringboot.unsubmit.mq.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Component
@RefreshScope
@RestController
@RequestMapping("/")
public class SubmitController {
    //@Value("${abc.a}")
    private String val;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MQSender mqSender;

    @GetMapping("/submit")
    @UnsubmitEnumeration(isCheck = false)
    public String submit() {

        return val;
    }

    @GetMapping("/sendTrace")
    public String sendTrace(String abc) {
        System.out.println(123);
        return "123";
    }


    @GetMapping("/sendFanout")
    public void sendFanout() throws InterruptedException {
        mqSender.sendFanout();
    }

        /*@GetMapping("/sendDdirect")
    public void sendMsg(){
        mqSender.sendDirect("direct");
    }

    @GetMapping("/sendTopic")
    public void sendTopic(){
        mqSender.sendTopic("topic");
    }

    @GetMapping("/sendHeader")
    public void sendHeader(){
        mqSender.sendHeader("header");
    }*/
}
