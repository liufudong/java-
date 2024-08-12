package com.example.a004spirngboot.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
    @GetMapping("/login")
    public ModelAndView hello() {
        System.out.println("Hello 222222222222222from Thymeleaf!222222222222222");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login2");
        modelAndView.addObject("message","登录页面");
        return modelAndView;
    }
}
