package com.wyc.servicefeign.Service.hystrix;

import com.wyc.servicefeign.Service.SchedualServiceHello;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHelloHystrix implements SchedualServiceHello {
    @Override
    public String sayHelloFromClientOne(String name) {
        return "sorry "+name;
    }
}
