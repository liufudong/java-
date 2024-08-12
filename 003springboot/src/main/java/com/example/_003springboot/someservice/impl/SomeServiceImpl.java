package com.example._003springboot.someservice.impl;

import com.example._003springboot.someservice.SomeService;
import org.springframework.stereotype.Service;

@Service("someService")
public class SomeServiceImpl implements SomeService {
    @Override
    public void sayHello(String name) {
        System.out.println("欢迎:" + name);
    }
}
