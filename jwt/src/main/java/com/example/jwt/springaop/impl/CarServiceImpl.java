package com.example.jwt.springaop.impl;

import com.example.jwt.springaop.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public void next() {
        System.out.println("CarServiceImpl next");
    }
}
