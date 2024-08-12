package com.example.mybatisplus;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatisplus.mapper.*;
import com.example.mybatisplus.pojo.*;
import com.example.mybatisplus.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest

@MapperScan(value = {"com.example.mybatisplus.mapper"})
class MybatisplusApplicationTests {
    //    @Resource
//    UserService userService;
    @Resource
    UserMapper userMapper;

    @Test
    public void testPaginate_withValidPageAndSize() {
        List<User> list = userMapper.selectList2();
        List<String> allData = Arrays.asList("Item1", "Item2", "Item3", "Item4", "Item5");
        PageResult<User> result = PaginationUtil.paginate(list, 2, 2);
        log.info("pageInfo222.getSize():" + result.toString());
        result.getData().forEach(user -> log.info("user:" + user));
//        PageResult<String> result2 = PaginationUtil.paginate(allData, 2, 2);
//        log.info("pageInfo4444.getSize():"+result2.size());

//        assertNotNull(result);
//        assertEquals(2, result.getPage());
//        assertEquals(2, result.getSize());
//        assertEquals(5, result.getTotal());
//        assertEquals(Arrays.asList("Item3", "Item4"), result.getData());
    }

    /**
     * 不知道为何 PageHelper失效了
     */
    @Test
    public void test() {

        //获取第1页，10条内容，默认查询总数count
        PageHelper.startPage(1, 10);
        List<User> list = userMapper.selectList2();
//用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);
        log.info("pageInfo.getSize():" + page.getSize());
        log.info("pageInfo.toString():" + page.toString());
        for (User user : list) {
            log.info("User ID: " + user.getId() + ", Name: " + user.getName());
        }
//测试PageInfo全部属性
//PageInfo包含了非常全面的分页属性
//        assertEquals(1, page.getPageNum());
//        assertEquals(10, page.getPageSize());
//        assertEquals(1, page.getStartRow());
//        assertEquals(10, page.getEndRow());
//        assertEquals(183, page.getTotal());
//        assertEquals(19, page.getPages());
////        assertEquals(1, page.getFirstPage());
////        assertEquals(8, page.getLastPage());
////        assertEquals(true, page.isFirstPage());
////        assertEquals(false, page.isLastPage());
//        assertEquals(false, page.isHasPreviousPage());
//        assertEquals(true, page.isHasNextPage());
    }

    @Test
    void contextLoads() {
    }

    @Resource
    PageMapper pageMapper;

    @Test
    public void test3() {

        //获取第1页，10条内容，默认查询总数count
        PageHelper.startPage(1, 10);
        List<PageHelperBean> list = pageMapper.selectList();
//用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);
        log.info("pageInfo.getSize():" + page.getSize());
        for (PageHelperBean user : list) {
            log.info("User ID: " + user.getId());
        }

    }

    @Autowired
    ClazzMapper clazzMapper;
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void test34() {
        Student studentAndClazz = studentMapper.getStudentAndClazz(1L);
        //Student{sid=1, sname='张三', cid=1001, clazz=Clazz{cid=1001, cname='高三1班'}}
        System.out.println("查询张三学生的信息:" + studentAndClazz.toString());
        Clazz clazzAndStudents = clazzMapper.getClazzAndStudents("高三1班");
        //因为这里有嵌套关系 故打印json {"cname":"高三1班","students":[{"sname":"张三","cid":1001,"sid":1},{"sname":"张三2","cid":1001,"sid":2}],"cid":1001}
        System.out.println("查询高三1班学生的信息:" + JSONObject.toJSON(clazzAndStudents));
//        map.forEach((key, value) ->{
//            System.out.println("Key = " + key + ", Value = " + value);
//        });
    }

    @Autowired
    CarMapper carMapper;

    @Test
    public void test56() {
        List<Car> cars = carMapper.selectByMultiCondition("丰田霸道", 321d, "燃油车");
        cars.forEach(car -> {
            System.out.println("car = " + car);
        });
    }

    @Test
    public void test78() {
//        List<Car> cars = carMapper.selectByMultiConditionWithTrim("丰田霸道", 321d, "燃油车");
        List<Car> cars = carMapper.selectByMultiConditionWithTrim(null, null, null);
        cars.forEach(car -> {
            System.out.println("car = " + car);
        });
    }

    @Test
    public void test89() {
//        List<Car> cars = carMapper.selectByMultiConditionWithTrim("丰田霸道", 321d, "燃油车");
        Car car = new Car();
        car.setId("174");
        car.setCarNum("7777");
        car.setBrand("宝马740");
        int count = carMapper.updateWithSet(car);
        System.out.println("count = " + count);
    }

    @Test
    public void test890() {
//        List<Car> cars = carMapper.selectWithChoose("丰田霸道", null, null);
//        System.out.println("cars = " + cars);
//        ==>  Preparing: SELECT * FROM t_car WHERE brand = ?
//        ==> Parameters: 丰田霸道(String)

//        List<Car> cars = carMapper.selectWithChoose(null, 320d, null);
//        System.out.println("cars = " + cars);
//        ==>  Preparing: SELECT * FROM t_car WHERE guide_price >= ?
//        ==> Parameters: 320.0(Double)

        List<Car> cars = carMapper.selectWithChoose(null, null, "2020-11-11");
        System.out.println("cars = " + cars);
//        ==>  Preparing: SELECT * FROM t_car WHERE produce_time= ?
//        ==> Parameters: 2020-11-11(String)
    }

    @Test
    public void testDeleteBatchByForeach() {
        int i = carMapper.deleteBatchByForeach(new String[]{"168", "169"});
        System.out.println("成功删除行数 = " + i);
    }

    @Test
    public void testAddBatchByForeach() {
        List<Car> cars = new ArrayList<>();
        Car car = null;
        for (int i = 0; i < 5; i++) {
            car = new Car();
            car.setCarNum("7777");
            car.setBrand("宝马" + i);
            car.setGuidePrice(new Double(i));
            car.setProduceTime(new Date(System.currentTimeMillis()));
            car.setCarType("新能源");
            cars.add(car);
        }
        int i = carMapper.addBatchByForeach(cars);
        System.out.println("成功添加行数 = " + i);
    }

    @Test
    public void testSelectSqlInclude2() {
        carMapper.selectSqlInclude2().forEach(car -> {
            System.out.println("car = " + car);
        });
    }
}
