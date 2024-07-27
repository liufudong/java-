package com.szh.loc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    @Value(value = "历史")
    private String name;

    @Override
    public String toString() {
        return "MyController{" +
                "name='" + name + '\'' +
                '}';
    }
}
