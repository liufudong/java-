package com.powernode.mybatis;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.mapper.TUserMapper;
import com.powernode.mybatis.mapper.TUserMapperJoin;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CarTest {
    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectByCarType("氢能源");
        list.forEach(car -> {
            System.out.println("===========car:" + car.toString());
        });
    }

    @Test
    public void testDsc() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectAll("desc");
        list.forEach(car -> {
            System.out.println("===========car:" + car.toString());
        });
    }

    @Test
    public void testTable() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);
        List<Car> list = mapper.selectAll("20000101");
        list.forEach(car -> {
            System.out.println("===========car:" + car.toString());
        });
    }

    @Test
    public void delete() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.delete("55");
        sqlSession.commit();
        sqlSession.close();
        System.out.println("count:" + count);
    }

    @Test
    public void deleteBatch() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteBatch("52,51");
        sqlSession.commit();
        sqlSession.close();
        System.out.println("count:" + count);
    }

    @Test
    public void selectLikeByBrand() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectLikeByBrand("丰田");
        sqlSession.commit();
        sqlSession.close();
        list.forEach(car -> {
            System.out.println("car:" + car);
        });
    }

    @Test
    public void testInsertUseGeneratedKeys() {
        // insert into t_car(id, car_num, branb, produce_time, car_type, guide_price) values (null, "5262", "BYD汉", "2020-10-11", "新能源", 30.3)
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car();
        car.setCarNum("5262");
        car.setBranb("BYD汉222");
        car.setGuidePrice(30.3);
        car.setProduceTime("2020-10-11");
        car.setCarType("新能源");
        mapper.insertUseGeneratedKeys(car);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("car.getId()===" + car.getId());
    }

    @Test
    public void testSelectTotal() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        System.out.println("===========testSelectTotal:" + mapper.selectTotal());
    }

    @Test
    public void testSelectByMultiCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiCondition("丰田", 90d, "氢能源");
        cars.forEach(car -> System.out.println("===========car:" + car));

    }

    //update t_car SET car_num = "1001, branb = "霸道2", guide_price = 10.0, produce_time = "2024-10-11", car_type = "新能源" where id = "66"
    @Test
    public void testUpdateWithSet() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(65L, "1001", "霸道2", 10.0, "2024-10-11", "新能源");
        int count = mapper.updateWithSet(car);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void deleteBatchByForeach() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteBatchByForeach(new Long[]{66L, 67L});
        System.out.println(count);
        sqlSession.commit();
    }
    @Test
    public void testInsertBatchByForeach(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car1 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        Car car2 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        Car car3 = new Car(null, "2001", "兰博基尼", 100.0, "1998-10-11", "燃油车");
        List<Car> cars = Arrays.asList(car1, car2, car3);
        int count = mapper.insertBatchByForeach(cars);
        System.out.println("插入了几条记录" + count);
        sqlSession.commit();
    }
    @Test
    public void testTUserMapperJoin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        TUserMapperJoin mapper = sqlSession.getMapper(TUserMapperJoin.class);
        Map<String, Object> map = mapper.selectStudentInfoByName("王五");
        System.out.println("map" + map);
    }
}
