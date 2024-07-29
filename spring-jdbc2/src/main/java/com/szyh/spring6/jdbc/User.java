package com.szyh.spring6.jdbc;

public class User {
    private int age;
    private int id;
    private String realName;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public User(int age, int id, String realName) {
        this.age = age;
        this.id = id;
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", id=" + id +
                ", realName='" + realName + '\'' +
                '}';
    }
}
