package com.szyh.bean;

import org.springframework.beans.factory.FactoryBean;

public class FactoryPerson implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
