package com.example.demo.controller;

import com.example.demo.util.RestTemplateFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return RestTemplateFactory.getRestTemplate().getForObject("https://www.baidu.com",String.class);
    }
}
