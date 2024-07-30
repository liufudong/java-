package com.szyh.aop;

import com.szyh.aop.service.OrderService;
import com.szyh.aop.service.OrderService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();

    }
    @Test
    public void test2(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Spring6Configuration.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }
//    @Test
//    public void test3(){
//        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Spring6Configuration.class);
//        OrderService2 orderService = applicationContext.getBean("orderService2", OrderService2.class);
//        orderService.generate();
//    }
}
