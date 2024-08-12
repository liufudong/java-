package com.example.ormmysql.controller;

import com.example.ormmysql.dao.StudentMapper;
import com.example.ormmysql.pojo.Student;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody

public class StudentController {
    @Resource
    StudentMapper mapper;

    @GetMapping(value = "/queryStudent")
    public Student queryStudent(@RequestParam(defaultValue = "", value = "id", required = false) int id) {
        Student student = mapper.selectStudentById(id);
        return student;
    }
    @GetMapping(value = "/selectStudentAll")
    public List<Student> selectStudentAll() {
        List<Student> students = mapper.selectStudentAll();
        students.forEach(student ->{
            System.out.println("======student=="+student.toString());
        });
        return students;
    }
}
