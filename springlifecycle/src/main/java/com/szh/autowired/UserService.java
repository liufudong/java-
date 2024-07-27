package com.szh.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    @Autowired
    @Qualifier("userDaoForOracel")
    private UserDao userDao;
    public void insert(){
        userDao.insert();
    }
}
