package com.szh.autowired;

import org.springframework.stereotype.Repository;

@Repository("userDaoForMySQL")
public class UserDaoForMySQL implements  UserDao{
    @Override
    public void insert() {
        System.out.println("正在向mysql数据库插入User数据");

    }
}
