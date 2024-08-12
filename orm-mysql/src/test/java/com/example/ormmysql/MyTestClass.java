package com.example.ormmysql;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.ormmysql.dao.StudentMapper;
import com.example.ormmysql.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyTestClass {
    @Autowired
    StudentMapper studentMapper;
    @Test
    public void testMyMethod() {
        Student student = studentMapper.selectStudentById(1);
        System.out.println("student:" + student);
    }
}