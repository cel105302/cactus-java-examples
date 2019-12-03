package com.cactus.demo.cactusspringboot.unsubmit.controller;

import com.cactus.demo.cactusspringboot.unsubmit.UnsubmitEnumeration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class SubmitController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/submit")
    @UnsubmitEnumeration(isCheck = false)
    public String submit(){

        return restTemplate.getForObject("http://localhost:8077/sendTrace", String.class);
    }

    @GetMapping("/sendTrace")
    public String sendTrace(){

        return "123";
    }

}
