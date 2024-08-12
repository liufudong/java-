package com.example.ormmysql.dao;

import com.example.ormmysql.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    Student selectStudentById(@Param("id") Integer id);
    List<Student> selectStudentAll();
}
