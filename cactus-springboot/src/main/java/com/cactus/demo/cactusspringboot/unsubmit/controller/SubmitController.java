package com.cactus.demo.cactusspringboot.unsubmit.controller;

import com.cactus.demo.cactusspringboot.unsubmit.UnsubmitEnumeration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SubmitController {

    @GetMapping("/submit")
    @UnsubmitEnumeration(isCheck = true)
    public String submit(){

        return "123";
    }
}
