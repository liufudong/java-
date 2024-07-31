package com.powernode.mybatis.mapper;


import com.powernode.mybatis.pojo.Car;

import java.util.List;

/**
 * Car的sql映射对象
 *
 * @author 老杜
 * @version 1.0
 * @since 1.0
 */
public interface CarMapper {

    /**
     * 根据car_num获取Car
     *
     * @param carType
     * @return
     */
    List<Car> selectByCarType(String carType);

    /**
     * 查询所有的Car
     *
     * @param ascOrDesc asc或desc
     * @return
     */
    List<Car> selectAll(String ascOrDesc);

    /**
     * 根据id批量删除
     *
     * @param ids
     * @return
     */
    int deleteBatch(String ids);

    /**
     * 根据id 删除单条
     *
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 根据品牌进行模糊查询
     *
     * @param likeBrank
     * @return
     */
    List<Car> selectLikeByBrand(String likeBrank);

    /**
     * 插入数据时获取自动生成的主键
     */
    void insertUseGeneratedKeys(Car car);
}