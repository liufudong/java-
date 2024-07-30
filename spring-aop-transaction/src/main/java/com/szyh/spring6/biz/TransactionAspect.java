package com.szyh.spring6.biz;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
// 事务切面类
public class TransactionAspect {
    //环绕
    @Around("execution(* com.szyh.spring6.biz..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint)  {
        System.out.println("开启事务");
        try {
            joinPoint.proceed();
            System.out.println("提交事务");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("回滚事务");
        }

    }
}
