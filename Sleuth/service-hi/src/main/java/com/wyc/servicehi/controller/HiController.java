package com.wyc.servicehi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class HiController {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String callHello(){
        logger.log(Level.INFO, "calling trace service-hi");
        return restTemplate.getForObject("http://localhost:8988/hello", String.class);
    }

    @RequestMapping("/hi")
    public String hi(){
        logger.log(Level.INFO, "calling trace service-hi");
        return "Hi, i'm from service-hi!";
    }
}
