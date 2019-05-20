package com.wyc.servicefeign.controller;

import com.wyc.servicefeign.Service.SchedualServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    SchedualServiceHello schedualServiceHello;

    @RequestMapping("/hello")
    public String sayHello(@RequestParam String name){
        return schedualServiceHello.sayHelloFromClientOne(name);
    }
}
