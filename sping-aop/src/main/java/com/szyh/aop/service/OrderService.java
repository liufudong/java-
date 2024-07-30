package com.szyh.aop.service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

// 目标类
@Service(value = "orderService")
public class OrderService {
    // 目标方法
    public void generate(){

        System.out.println("订单已生成！");
//        if (1 == 1) {
//            throw new RuntimeException("模拟异常发生");
//        }
    }
}