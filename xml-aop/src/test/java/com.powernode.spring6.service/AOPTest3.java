package com.powernode.spring6.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest3 {
    @Test
    public void testAOPXML(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        VipService vipService = applicationContext.getBean("vipService", VipService.class);
        vipService.add();

    }
}
