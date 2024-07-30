package com.szyh.spring6.biz;

import org.springframework.stereotype.Component;

// 业务类
@Component("accountService")
public class AccountService {
    // 转账业务方法
    public void transfer(){
        System.out.println("正在进行银行账户转账");
    }
    // 取款业务方法
    public void withdraw(){
        System.out.println("正在进行取款操作");
    }
}
