package com.java1234.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "spring.path2")
@Component
public class PathSourceProperties {
    private String text;
    private String text2;

    @Override
    public String toString() {
        return "PathSourceProperties{" +
                "text='" + text + '\'' +
                ", text2='" + text2 + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}