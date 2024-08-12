package com.example.jwt.jwtutil;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // 在方法执行之前执行
    @Before("execution(* com.example.jwt.springaop.impl.CarServiceImpl.next(..))")
    public void logBeforeNext(){
        System.out.println("Before calling next()");
    }
    // 在方法执行之后执行
    @After("execution(* com.example.jwt.springaop.impl.CarServiceImpl.next(..))")
    public void logAfterNext() {
        System.out.println("After calling next()");
    }
}

