package com.powernode.mybatis;

import com.powernode.mybatis.mapper.StudentMapper;
import com.powernode.mybatis.pojo.Student;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapperTest {
    @Test
    public void testSelectByName() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.selectByName("张三");
        list.forEach(student -> {
            System.out.println("student:" + student.toString());
        });
        sqlSession.close();
    }

    @Test
    public void selectById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1L);
        System.out.println("student:" + student.toString());
        sqlSession.close();
    }

    @Test
    public void selectByBirth() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        String string="2022-08-16";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(string);
            List<Student> list = mapper.selectByBirth(date);
            list.forEach(student -> {
                System.out.println("student:" + student.toString());
            });
            sqlSession.close();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void selectBySex() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.selectBySex('男');
        list.forEach(student -> {
            System.out.println("student:" + student.toString());
        });
        sqlSession.close();
    }

    @Test
    public void selectByParamMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String,Object> map=new HashMap<>();
        map.put("nameKey", "张三");
        map.put("ageKey", 20);
        List<Student> list = mapper.selectByParamMap(map);
        list.forEach(student -> {
            System.out.println("student:" + student.toString());
        });
        sqlSession.close();
    }
    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("李四");
        student.setAge(30);
        student.setHeight(1.70);
        student.setSex('男');
        student.setBirth(new Date());
        int count = mapper.insert(student);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void selectByNameAndAge() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.selectByNameAndAge("张三",20).forEach(student -> {
            System.out.println("student1:"+student);
        });
    }
    @Test
    public void selectByIdRetMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> stringObjectMap = mapper.selectByIdRetMap(3L);
        System.out.println("stringObjectMap:"+stringObjectMap);
        sqlSession.close();
    }
    @Test
    public void testSelectAllRetListMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Map<String, Object>> maps = mapper.selectAllRetListMap();
        maps.forEach(map->{
            System.out.println("map:"+map);
        });
    }
    @Test
    public void testSelectAllRetMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<Long, Map<String, Object>> longMapMap = mapper.selectAllRetMap();
        longMapMap.forEach((innerKey, innerValue)->{
            // innerKey是String类型的键，innerValue是对应的Object值
            System.out.println("  Inner Key: " + innerKey + ", Value: " + innerValue);
        });
    }
}
