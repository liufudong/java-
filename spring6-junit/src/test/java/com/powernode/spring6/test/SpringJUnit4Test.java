//package com.powernode.spring6.test;
//
//import com.powernode.spring6.bean.Spring6Configuration;
//import com.powernode.spring6.bean.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring.xml")
//public class SpringJUnit4Test {
//    @Test
//    public void test1() {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Configuration.class);
//        User user1 = applicationContext.getBean("user", User.class);
//        System.out.println("user1" + user1);
//    }
//    @Autowired
//    private User user;
//    @Test
//    public void test2() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        User user1 = applicationContext.getBean("user", User.class);
//        System.out.println("user1" + user1);
//    }
//    @Test
//    public void test3() {
//        System.out.println("user" + user);
//    }
//}
