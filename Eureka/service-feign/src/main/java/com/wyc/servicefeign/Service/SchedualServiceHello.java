package com.wyc.servicefeign.Service;

import com.wyc.servicefeign.Service.hystrix.SchedualServiceHelloHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hello", fallback = SchedualServiceHelloHystrix.class)
public interface SchedualServiceHello {

    @RequestMapping("/hello")
    String sayHelloFromClientOne(@RequestParam("name") String name);
}
