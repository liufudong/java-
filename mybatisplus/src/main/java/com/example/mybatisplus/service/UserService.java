package com.example.mybatisplus.service;

import com.example.mybatisplus.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    List<User> selectList();

    PageInfo<User> listUsers(int pageNum, int pageSize);
}
