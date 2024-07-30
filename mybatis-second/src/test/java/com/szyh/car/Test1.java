package com.szyh.car;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class Test1 {
    @Test
    public void test1() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            int insert = sqlSession.insert("car.insert");
            sqlSession.commit();
            System.out.println("insert:" + insert);
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void test2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml")).openSession();
            HashMap<String,String> map=new HashMap<>();
            map.put("car_num","1");
            map.put("branb","小牛v999");
            map.put("produce_time","2020-11-04");
            map.put("car_type","燃油车");
            map.put("guide_price","-1");
            int insert = sqlSession.insert("car.insert2",map);

            sqlSession.commit();
            System.out.println("insert:" + insert);
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void test3() {
        SqlSession sqlSession = null;
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml")).openSession();
            Car car = new Car("103", "1丰田v我5022", 90f, "2014-10-05", "氢能源");
            int insert = sqlSession.insert("car.insert3",car);

            sqlSession.commit();
            System.out.println("insert:" + insert);
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void delete1() {
        SqlSession sqlSession = null;
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml")).openSession();
            int delete = sqlSession.delete("car.delete","29");
            sqlSession.commit();
            System.out.println("delete:" + delete);
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void update1() {
        SqlSession sqlSession = null;
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml")).openSession();
            HashMap<String,String> map=new HashMap<>();
            map.put("branb","达拉斯小牛");
            map.put("id","33");
            int update = sqlSession.update("car.update",map );
            sqlSession.commit();
            System.out.println("update:" + update);
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void selectAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml")).openSession();
            List<Car> objects = sqlSession.selectList("car.selectAll");
            for (Car object : objects) {
                System.out.println("object:"+object.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void selectOne() {
        SqlSession sqlSession = null;
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml")).openSession();
            Car objects = sqlSession.selectOne("car.selectOne","34");
            System.out.println("object:"+objects.toString());

        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
