package com.powernode.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;

//负责记时的切面类
public class TimerAspect {
    public void time(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        //执行目标
        proceedingJoinPoint.proceed();
        System.out.println("耗时" + (System.currentTimeMillis() - begin) + "毫秒");
    }
    public void  before( ) throws Throwable {
        System.out.println("before");
    }
}
