package com.szyh.invoke;

public class SystemService {
    private String name;
    public String age;

    public void setAge(String age) {
        System.out.println("setAge:"+age);
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "SystemService{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public SystemService() {
    }

    public void logout(){
        System.out.println("退出系统");
    }

    public boolean login(String username, String password){
        if ("admin".equals(username) && "admin123".equals(password)) {
            return true;
        }
        return false;
    }

    public boolean login(String password){
        System.out.println("login:"+password);
        if("110".equals(password)){
            return true;
        }
        return false;
    }
}
