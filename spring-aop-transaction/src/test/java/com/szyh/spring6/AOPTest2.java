package com.szyh.spring6;

import com.szyh.spring6.biz.AccountService;
import com.szyh.spring6.biz.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest2 {
    @Test
    public void test1(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Spring6Configuration.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        orderService.generate();
        orderService.cancel();
        accountService.transfer();
        accountService.withdraw();

    }
}
