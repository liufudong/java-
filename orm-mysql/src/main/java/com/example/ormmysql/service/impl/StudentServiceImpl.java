package com.example.ormmysql.service.impl;

import com.example.ormmysql.dao.StudentMapper;
import com.example.ormmysql.pojo.Student;
import com.example.ormmysql.service.StudentService;
import jakarta.annotation.Resource;

public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper mapper;
    @Override
    public Student queryStudent(Integer id) {
        return mapper.selectStudentById(id);
    }
}
