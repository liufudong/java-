package com.powernode.mybatis;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.mapper.TUserMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarTest {
    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectByCarType( "氢能源");
        list.forEach(car -> {
            System.out.println("===========car:"+car.toString());
        });
    }
    @Test
    public void testDsc() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectAll("desc");
        list.forEach(car -> {
            System.out.println("===========car:"+car.toString());
        });
    }
    @Test
    public void testTable() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);
        List<Car> list = mapper.selectAll("20000101");
        list.forEach(car -> {
            System.out.println("===========car:"+car.toString());
        });
    }
    @Test
    public void delete() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.delete("55");
        sqlSession.commit();
        sqlSession.close();
        System.out.println("count:"+count);
    }
    @Test
    public void deleteBatch() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteBatch("52,51");
        sqlSession.commit();
        sqlSession.close();
        System.out.println("count:"+count);
    }
    @Test
    public void selectLikeByBrand() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectLikeByBrand("丰田");
        sqlSession.commit();
        sqlSession.close();
        list.forEach(car -> {
            System.out.println("car:"+car);
        });
    }
    @Test
    public void testInsertUseGeneratedKeys(){
        // insert into t_car(id, car_num, branb, produce_time, car_type, guide_price) values (null, "5262", "BYD汉", "2020-10-11", "新能源", 30.3)
        SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory().openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car();
        car.setCarNum("5262");
        car.setBranb("BYD汉");
        car.setGuidePrice(30.3);
        car.setProduceTime("2020-10-11");
        car.setCarType("新能源");
        mapper.insertUseGeneratedKeys(car);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("car.getId()==="+car.getId());
    }
}
