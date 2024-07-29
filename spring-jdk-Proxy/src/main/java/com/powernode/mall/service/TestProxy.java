package com.powernode.mall.service;

import com.powernode.mall.service.impl.OrderServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        OrderService target = new OrderServiceImpl();

        OrderService proxy =(OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyTimerInvocationHandler(target));
        //如果打印 "proxy:null" ,则记得在InvocationHandler return xxxx;
        System.out.println("proxy:" + proxy);

        // 第三步：调用代理对象的代理方法
        proxy.detail();
        proxy.modify();
        proxy.generate();
    }

    static class MyTimerInvocationHandler implements InvocationHandler {
        OrderService orderService;

        public MyTimerInvocationHandler(OrderService orderService) {
            this.orderService = orderService;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long start = System.currentTimeMillis();
            Object o = method.invoke(orderService, args);
            System.out.println(""+orderService.getClass().getName()+"的"+method.getName()+"耗时毫秒:"+(System.currentTimeMillis()-start));
            return  o;
        }
    }
}
