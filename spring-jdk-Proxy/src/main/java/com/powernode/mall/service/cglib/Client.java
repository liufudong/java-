package com.powernode.mall.service.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {
        // 创建字节码增强器
        Enhancer enhancer = new Enhancer();
        // 告诉cglib要继承哪个类
        enhancer.setSuperclass(UserService.class);
        // 设置回调接口
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object orderService, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long start = System.currentTimeMillis();
                Object o = methodProxy.invokeSuper(orderService, args);
                System.out.println(""+orderService.getClass().getName()+"的"+method.getName()+"耗时毫秒:"+(System.currentTimeMillis()-start));

                return o;
            }
        });
        // 生成源码，编译class，加载到JVM，并创建代理对象
        UserService userService = (UserService) enhancer.create();
        userService.login();
        userService.logout();
    }
}

