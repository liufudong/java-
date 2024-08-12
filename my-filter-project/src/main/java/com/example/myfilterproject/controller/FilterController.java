package com.example.myfilterproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {
    @GetMapping("/filter")
    public String getText() {
        return "filter";
    }
}
