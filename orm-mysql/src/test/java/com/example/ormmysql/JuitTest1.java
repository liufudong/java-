package com.example.ormmysql;

import com.example.ormmysql.dao.StudentMapper;
import com.example.ormmysql.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
public class JuitTest1 {
    @Mapper
    StudentMapper studentMapper;

    @Test
    private void test() {
        Student student = studentMapper.selectStudentById(1);
        System.out.println("student:" + student);
    }
}
