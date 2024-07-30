package com.powernode.bank.service.impl;

import com.powernode.bank.impl.AccountDaoImpl;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.service.IsolationService1;
import com.powernode.bank.service.IsolationService2;
import com.powernode.bank.service.Spring6Config;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountServiceImplTest {
    @Test
    public void testAccountServiceImpl() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountServiceImpl.class);
        accountService.transfer("act-001", "act-002", 10000);
//        accountService.save(new Account("张三",900000d));
        Logger logger = LoggerFactory.getLogger(AccountServiceImplTest.class);
        logger.info("=========");

    }

    /***
     * todo 事务隔离机制有点懵逼
     */
    @Test
    public void testAccountServiceImpl2() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 isolationService2 = applicationContext.getBean("i2", IsolationService2.class);
        isolationService2.save(new Account("act-81",900000d));

//        IsolationService1 isolationService1 = applicationContext.getBean("i1", IsolationService1.class);
//        isolationService1.getByActno("act-79");
    }
    @Test
    public void testAccountServiceImpl3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 isolationService2 = applicationContext.getBean("i2", IsolationService2.class);
        isolationService2.save(new Account("act-77",900000d));
    }
    @Test
    public void testAccountServiceImpl4() {
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(Spring6Config.class);
        AccountService accountServiceImpl = applicationContext.getBean("accountServiceImpl", AccountService.class);
        accountServiceImpl.transfer("act-001", "act-002", 10000);
        System.out.println("====accountService=="+accountServiceImpl);

    }
}
