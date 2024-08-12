package com.example.mybatisplus.mapper;

import com.example.mybatisplus.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * todo
 * todo
 * todo https://poe.com/ AI问法
 * CREATE TABLE t_student (
 * id bigint(20) NOT NULL AUTO_INCREMENT,
 * name varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 * age int(11) NULL DEFAULT NULL,
 * height double NULL DEFAULT NULL,
 * birth date NULL DEFAULT NULL,
 * sex char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 * cid varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 * PRIMARY KEY (id) USING BTREE
 * ) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 * CREATE TABLE t_clazz (
 * cid int(11) NOT NULL,
 * cname varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 * PRIMARY KEY (cid) USING BTREE
 * ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 * 我用mybatis 1.通过学生id 怎么查询t_student学生+t_clazz信息 2.通过t_clazz的cname查询到班级信息和学生信息
 */

// SELECT s.*, c.cname
//         FROM t_student s
//         LEFT JOIN t_clazz c ON s.cid = c.cid
//         WHERE s.id = 1
@Mapper
public interface StudentMapper {
    Student getStudentAndClazz(Long sid);

}
