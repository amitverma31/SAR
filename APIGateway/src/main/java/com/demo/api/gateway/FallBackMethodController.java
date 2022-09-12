package com.demo.api.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
    @GetMapping("/userServiceFallback")
    public String userServiceFallBackMethod (){
        return "User service is taking time, please try again";
    }

    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallBackMethod (){
        return "Department service is taking time, please try again";
    }
}
