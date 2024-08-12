package com.example.jwt;

import com.example.jwt.jwtutil.JwtExample;
import com.example.jwt.springaop.CarService;
import com.example.jwt.springaop.impl.CarServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.jwt")
class JwtApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        String token = JwtExample.createJwtToken("123456");
        System.out.println("JWT Token: " + token);
        JwtExample.validateJwtToken(token);
    }

    @Autowired
    CarService carService;

    @Test
    void testAop() {
        carService.next();
    }

}
