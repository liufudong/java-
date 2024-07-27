package com.szh.autowired;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userResourceService")
public class UserResourceService {

    private UserDao userDao;
//    @Resource(name = "张三")
//    private String name;

    @Resource(name = "userDaoForMySQL")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insert(){
        userDao.insert();
    }
}
