package com.szyh.ldd.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component()
public class MyComponet {

    private String name;

//    public MyComponet(      String name) {
//        this.name = name;
//    }
    @Value("里斯")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyComponet{" +
                "name='" + name + '\'' +
                '}';
    }
}
