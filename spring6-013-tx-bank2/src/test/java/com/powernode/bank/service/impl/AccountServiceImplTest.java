package com.powernode.bank.service.impl;

import com.powernode.bank.impl.AccountDaoImpl;
import com.powernode.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountServiceImplTest {
    @Test
    public void testAccountServiceImpl() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountServiceImpl.class);
        accountService.transfer("act-001","act-002",10000);

    }
}
