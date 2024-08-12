package com.example.spinrfilter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyResController {
    @GetMapping("/")
    public ModelAndView modelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("model.html");
        modelAndView.addObject("message", "我是hello2");
        return modelAndView;
    }
}
