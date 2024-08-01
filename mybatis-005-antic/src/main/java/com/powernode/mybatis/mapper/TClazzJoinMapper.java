package com.powernode.mybatis.mapper;


import com.powernode.mybatis.pojo.TClazzJoin;

import java.util.Map;

/**
 * Car的sql映射对象
 * @author 老杜
 * @version 1.0
 * @since 1.0
 */
public interface TClazzJoinMapper {
    /**
     * 根据cid获取Clazz信息
     * @param cid
     * @return
     */
    TClazzJoin selectByCid(Integer cid);

    /**
     * 根据班级编号查询班级信息。同时班级中所有的学生信息也要查询。
     * @param cid
     * @return
     */
    TClazzJoin selectClazzAndStusByCid(Integer cid);
}