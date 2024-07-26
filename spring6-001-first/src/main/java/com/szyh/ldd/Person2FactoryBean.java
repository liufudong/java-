package com.szyh.ldd;

import org.springframework.beans.factory.FactoryBean;

public class Person2FactoryBean implements FactoryBean<Person2> {
    @Override
    public Person2 getObject() throws Exception {
        return new Person2();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
