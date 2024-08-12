package com.example.mybatisplus.mapper;

import com.example.mybatisplus.pojo.PageHelperBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PageMapper {
    List<PageHelperBean> selectList();
}
