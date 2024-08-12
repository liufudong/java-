package com.example._003springboot.someservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${myapp.greeting}")
    private String greeting;

    @GetMapping("/greeting")
    public String getGreeting() {
        return greeting;
    }
}