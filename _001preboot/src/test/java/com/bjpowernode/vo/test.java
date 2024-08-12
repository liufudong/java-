package com.bjpowernode.vo;

import com.bjpowernode.springconfig.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println("========student" + student);
    }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = applicationContext.getBean("getStudent", Student.class);
        System.out.println("========student" + student);
    }
    @Test
    public void test3() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = applicationContext.getBean("makeStudent", Student.class);
        System.out.println("========student" + student);
    }
    @Test
    public void test4() {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println("========student" + student);
    }
}
