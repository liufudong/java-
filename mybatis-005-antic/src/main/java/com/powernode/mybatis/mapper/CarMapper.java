package com.powernode.mybatis.mapper;


import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

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
     * 更新信息，使用set标签
     * @param car
     * @return
     */
    int updateWithSet(Car car);

    /**
     * 通过foreach完成批量删除
     * @param ids
     * @return
     */
    int deleteBatchByForeach(@Param("ids") Long[] ids);

    /**
     * 获取总记录条数
     * @return
     */
    Long selectTotal();
    /**
     * if标签
     * 根据多条件查询Car
     * @param branb
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiCondition(@Param("branb") String branb, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

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

    /**
     * 批量添加，使用foreach标签
     * @param cars
     * @return
     */
    int insertBatchByForeach(@Param("cars") List<Car> cars);
}