package com.example.a004spirngboot.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boot004")
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from /boot004/";
    }

    // 其他方法...
}