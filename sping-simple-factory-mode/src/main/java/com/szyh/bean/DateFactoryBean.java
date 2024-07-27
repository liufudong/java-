package com.szyh.bean;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFactoryBean implements FactoryBean<Date> {
    private String date;

    public DateFactoryBean(String date) {
        this.date = date;
    }

    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(date);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
