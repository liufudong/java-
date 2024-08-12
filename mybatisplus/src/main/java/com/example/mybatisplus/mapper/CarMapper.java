package com.example.mybatisplus.mapper;

import com.example.mybatisplus.pojo.Car;
import com.example.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CarMapper {

    /**
     * 根据多条件查询Car
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiCondition(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);


    /***
     *     trim标签
     *     trim标签的属性：
     * prefix：在trim标签中的语句前添加内容
     * suffix：在trim标签中的语句后添加内容
     * prefixOverrides：前缀覆盖掉（去掉）
     * suffixOverrides：后缀覆盖掉（去掉）
     */
    /**
     * 根据多条件查询Car，使用trim标签
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithTrim(@Param("brand") String brand,
                                             @Param("guidePrice") Double guidePrice,
                                             @Param("carType") String carType);

    /**
     * 更新信息，使用set标签
     * @param car
     * @return
     */
    int updateWithSet(Car car);


    /**
     * 只有一个分支会被选择！！！！
     * 需求：先根据品牌查询，如果没有提供品牌，再根据指导价格查询，如果没有提供指导价格，就根据生产日期查询。
     * 使用choose when otherwise标签查询
     * @param brand
     * @param guidePrice
     * @param produceTime
     * @return
     */
    List<Car> selectWithChoose(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("produceTime") String produceTime);

    /**
     * 通过foreach完成批量删除
     * @param ids
     * @return
     */
    int deleteBatchByForeach(@Param("ids") String[] ids);

    /**
     * 通过foreach完成批量添加
     * @param carList
     * @return
     */
    int addBatchByForeach(@Param("carList") List<Car> carList);


    /**
     * sql标签与include标签
     * @param
     * @return
     */
    List<Car> selectSqlInclude2();
}
