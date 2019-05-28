package com.wyc.servicehello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class HelloController {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String callHi(){
        logger.log(Level.INFO, "calling trace service-hello");
        return restTemplate.getForObject("http://localhost:8989/hi", String.class);
    }

    @RequestMapping("/hello")
    public String hello(){
        logger.log(Level.INFO, "calling trace service-hello");
        return "Hello, i'm from service-hello!";
    }

}
