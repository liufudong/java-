package com.powernode.mybatis.mapper;


import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.pojo.TUserJoin;

import java.util.List;
import java.util.Map;

/**
 * Car的sql映射对象
 * @author 老杜
 * @version 1.0
 * @since 1.0
 */
public interface TUserMapperJoin {

    /**
     * 查询一个班级对应多个学生。班级表：t_clazz 有cid，cname字段。学生表：t_student2有sid,sname,cid(和t_calzz)字段，mybatics3.5
     * 怎么通过学生名查询学生的sid,cid
     */
    TUserJoin selectStudentInfoByName(String studentName);
    /**
     * 根据cid获取Clazz信息
     * @param cid
     * @return
     */
    List<TUserJoin> selectBySid(Integer cid);
}