package com.cactus.demo.cactusspringboot.unsubmit.controller;

import com.cactus.demo.cactusspringboot.unsubmit.UnsubmitEnumeration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;

@Component
@RefreshScope
@RestController
@RequestMapping("/")
public class SubmitController {
    @Value("${abc.a}")
    private String val;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/submit")
    @UnsubmitEnumeration(isCheck = false)
    public String submit(){

        return val;
    }

    @GetMapping("/sendTrace")
    public String sendTrace(String abc){
        System.out.println(123);
        return "123";
    }

    public static void main(String[] args) {
        String hexStr =  "0123456789ABCDEF";
        byte[] b = Integer.toBinaryString(1).getBytes();

        try {
            SubmitController.class.getMethod("sendTrace", String.class).invoke(SubmitController.class.newInstance(),"123");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        String hex=null;
        int pos;
        /*for(int i=0;i<b.length;i++){
            //字节高4位
            hex = String.valueOf(hexStr.charAt((b[i]&0xF0)>>4));
            //字节低4位
            hex += String.valueOf(hexStr.charAt(b[i]&0x0F));
        }*/

        System.out.println(Integer.toHexString(16));
        System.out.println(hexStr.charAt((16&0xF0)>>4));
        System.out.println(hexStr.charAt((16&0x0F)));
    }
}
