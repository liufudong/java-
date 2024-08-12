package com.example._003springboot.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
    @GetMapping("/testRestController")

    public Person test1(){
        Person person=new Person();
        return person;
    }
}
