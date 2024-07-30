package com.szyh.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect()
@Component("myAspect2")
//如果多个切面的话，顺序如何控制：可以使用@Order注解来标识切面类，为@Order注解的value指定一个整数型的数字，数字越小，优先级越高。
@Order(1)
public class MyAspect2 {
    //将切点表达式单独的定义出来， 使用@Pointcut注解来定义独立的切点表达式。 注意这个@Pointcut注解标注的方法随意，只是起到一个能够让@Pointcut注解编写的位置。
    @Pointcut("execution(* com.szyh.aop.service.OrderService.*(..))")
    public void pointcut(){

    }
    @Before("pointcut()")
    // 前置通知：@Before 目标方法执行之前的通知
    public void generateBefore(){
        System.out.println("MyAspect2我是一个Before前置通知");
    }

    //环绕通知：@Around 目标方法之前添加通知，同时目标方法执行之后添加通知。
    @Around("pointcut()")
    public void generateAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("MyAspect2我是一个Around环绕通知开始");
        proceedingJoinPoint.proceed();
        System.out.println("MyAspect2我是一个Around环绕通知结束");
    }
    //异常通知：@AfterThrowing 发生异常之后执行的通知
    @AfterThrowing("pointcut()")
    public void generateThrowing(){
        System.out.println("MyAspect2我是一个AfterThrowing异常通知");
    }
    //后置通知：@AfterReturning 目标方法执行之后的通知
    @AfterReturning("pointcut()")
    public void generateAfterReturning(){
        System.out.println("MyAspect2我是一个AfterReturning后置通知");

    }
    //最终通知：@After 放在finally语句块中的通知
    @After("pointcut()")
    public void generateAfter(){
        System.out.println("MyAspect2我是一个After最终通知");
    }
}

