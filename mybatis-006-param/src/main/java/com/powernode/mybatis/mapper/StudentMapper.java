package com.powernode.mybatis.mapper;


import com.powernode.mybatis.pojo.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 学生数据Sql映射器
 *
 * @author 老杜
 * @version 1.0
 * @since 1.0
 */
public interface StudentMapper {
    /**
     * 根据name查询
     *
     * @param name
     * @return
     */
    List<Student> selectByName(String name);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Student selectById(Long id);

    /**
     * 根据birth查询
     *
     * @param birth
     * @return
     */
    List<Student> selectByBirth(Date birth);

    /**
     * 根据sex查询
     *
     * @param sex
     * @return
     */
    List<Student> selectBySex(Character sex);

    /**
     * 根据name和age查询
     *
     * @param paramMap
     * @return
     */
    List<Student> selectByParamMap(Map<String, Object> paramMap);

    /**
     * 根据name和age查询
     *
     * @param name
     * @param age
     * @return
     */
    List<Student> selectByNameAndAge(@Param("name") String name, @Param("age") int age);

    /**
     * 保存学生数据
     *
     * @param student
     * @return
     */
    int insert(Student student);

    /**
     * 通过id查询一条记录，返回Map集合
     * @param id
     * @return
     */
    Map<String, Object> selectByIdRetMap(Long id);

    /**
     * 查询所有的Car，返回一个List集合。List集合中存储的是Map集合。
     * @return
     */
    List<Map<String,Object>> selectAllRetListMap();

    /**
     * 获取所有的Car，返回一个Map集合。
     * Map集合的key是Car的id。
     * Map集合的value是对应Car。
     * @return
     */
    @MapKey("id")
    Map<Long,Map<String,Object>> selectAllRetMap();
}