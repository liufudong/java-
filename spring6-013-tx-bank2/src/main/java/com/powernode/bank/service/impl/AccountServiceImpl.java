package com.powernode.bank.service.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountServiceImpl")
//@Transactional
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;


//    @Transactional//事务 在类上添加该注解，该类中所有的方法都有事务。在某个方法上添加该注解，表示只有这个方法使用事务。
    @Override
    public void transfer(String fromActno, String toActno, double money) {
        // 查询账户余额是否充足
        Account fromAccount = accountDao.selectByActno(fromActno);
        if (fromAccount.getBalance() < money) {
            throw new RuntimeException("账户余额不足");
        }
        // 余额充足，开始转账
        Account toAccount = accountDao.selectByActno(toActno);
        fromAccount.setBalance(fromAccount.getBalance() - money);
        toAccount.setBalance(toAccount.getBalance() + money);

        int count = accountDao.update(fromAccount);
        // 模拟异常
        String s = null;
        s.toString();
        count += accountDao.update(toAccount);
        if (count != 2) {
            throw new RuntimeException("转账失败，请联系银行");
        }else {
            System.out.println("转账成功");
        }
    }
}
