package com.szyh.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//切面类
@Component("myAspect")
@Aspect
@Order(2)
public class MyAspect {
    //service包下所有的类中以delete开始的所有方法
    // execution(public * com.powernode.mall.service.*.delete*(..))
    //mall包下所有的类的所有的方法
    // execution(* com.powernode.mall..*(..))
    //所有类的所有方法
    // execution(* *(..))



    // 切点表达式
    @Before("execution(* com.szyh.aop.service.OrderService.*(..))")
    // 这就是需要增强的代码（通知）
    public void advice(){
        System.out.println("MyAspect 我是一个Before通知");
    }
}
