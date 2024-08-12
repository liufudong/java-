package com.example.mybatisplus.mapper;

import com.example.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    List<User> selectList();
    List<User> selectList2();
}
