package com.szyh.spring6.user;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//编写一个负责安全的切面类 凡事在系统中进行修改操作的，删除操作的，新增操作的，都要把这个人记录下来。因为这几个操作是属于危险行为。例如有业务类和业务方法：
@Aspect
@Component
public class SecurityAspect {
    @Pointcut("execution(* com.szyh.spring6.user..get*(..))")
    private void getUser() {
    }

    @Pointcut("execution(* com.szyh.spring6.user..save*(..))")
    public void saveUser() {
    }

    @Pointcut("execution(* com.szyh.spring6.user..delete*(..))")
    public void deleteUser() {
    }

    @Pointcut("execution(* com.szyh.spring6.user..modey*(..))")
    public void modifyUser() {
    }

    @Before("getUser() || saveUser() ||deleteUser() ||modifyUser() ")
    public void beforeAdivce(JoinPoint joinpoint) {
        System.out.println("XXX操作员正在操作" + joinpoint.getSignature().getName() + "方法");
    }
}
