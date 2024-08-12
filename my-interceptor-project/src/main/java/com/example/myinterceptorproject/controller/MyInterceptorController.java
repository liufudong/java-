package com.example.myinterceptorproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyInterceptorController {
    @GetMapping("/interceptor")
    public String getText() {
        return "interceptor";
    }
}
