package com.szyh;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class sss {
    @Test
    public void testFirst() {
        System.out.println("============1111");
        System.out.println("============22222");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("sprinr-helloworld.xml");
        Object userBean = applicationContext.getBean("userBean");
        System.out.println("userBean:"+userBean);
    }
}
