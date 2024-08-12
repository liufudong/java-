package com.example._003springboot.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Thymeleaf视图
@Controller
public class TestController {
    @GetMapping("/controller")
    public String hello(Model model) {
        model.addAttribute("message", "Hello from Thymeleaf!");
        System.out.println("Hello from Thymeleaf!");
        return "hello";
    }
}
