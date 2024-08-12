package com.bjpowernode.vo;

import com.bjpowernode.springconfig.SpringConfig;
import com.bjpowernode.springconfig.SystemConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test2 {
    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SystemConfig.class);
        Tiger tiger = applicationContext.getBean("tiger", Tiger.class);
        System.out.println("tiger:" + tiger);

    }
}
