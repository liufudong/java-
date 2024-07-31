package com.powernode.mybatis.mapper;


import com.powernode.mybatis.pojo.Car;

import java.util.List;

/**
 * Car的sql映射对象
 * @author 老杜
 * @version 1.0
 * @since 1.0
 */
public interface TUserMapper {

    /**
     * 查询所有的Car
     * @param table 根据表名拼接
     * @return
     */
    List<Car> selectAll(String table);
}