package com.szh.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private String name;

    public User() {
        System.out.println("1.实例化Bean");
    }

    public void initBean() {
        System.out.println("3.初始化Bean");
    }

    public void destroyBean() {
        System.out.println("5.销毁Bean");
    }


    public void setName(String name) {
        System.out.println("2.Bean赋值");
        this.name = name;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader"+classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory beanFactory:"+beanFactory);

    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName s:"+s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy:");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet:");

    }
}
