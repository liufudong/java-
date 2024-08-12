package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> selectList() {
        return null;
    }

    @Override
    public PageInfo<User> listUsers(int pageNum, int pageSize) {
        return null;
    }
//    @Resource
//    UserMapper mapper;
//    @Override
//    public List<User> selectList() {
//        return mapper.selectList();
//    }
//
//    @Override
//    public PageInfo<User> listUsers(int pageNum, int pageSize) {
//        //pageNum:5,pageSize:10
//        log.info("pageNum:"+pageNum+",pageSize:"+pageSize);
//        //开始分页
//        PageHelper.startPage(pageNum, pageSize);
//        // 紧跟在这个方法后的第一个 MyBatis 查询会被分页
//        List<User> users = mapper.selectList2();
//        // 使用 PageInfo 包装查询后的结果，方便获取分页信息
//        PageInfo<User> pageInfo=new PageInfo<>(users,1);
//        log.info("pageInfo:"+pageInfo.getSize());//64
//        return pageInfo;
//    }
}
