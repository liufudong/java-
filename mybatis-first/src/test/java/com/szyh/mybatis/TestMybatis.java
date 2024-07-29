package com.szyh.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class TestMybatis {
    @Test
    public void test1() {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactory build = SqlSessionUtil.sqlSessionFactory;
            // 3. 创建SqlSession对象  传true自动提交
            sqlSession = build.openSession();
            // 4. 执行sql
            int insertCar = sqlSession.insert("insertCar");
            System.out.println("insertCar:" + insertCar);
            // 5. 提交（mybatis默认采用的事务管理器是JDBC，默认是不提交的，需要手动提交。）
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            // 6. 关闭资源（只关闭是不会提交的）
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void testInsert1() {
        SqlSession sqlSession = null;
        try {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("carNum", 103);
            map.put("branb", "丰田v50");
            map.put("guidePrice", 90);
            map.put("produceTime", 2014 - 10 - 05);
            map.put("carType", "氢能源");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = build.openSession();
            sqlSession.insert("insertCar2", map);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void testInsert2() {
        SqlSession sqlSession = null;
        try {
            Car car = new Car("103", "丰田v我5022", 90f, "2014-10-05", "氢能源");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = build.openSession();
            sqlSession.insert("insertCarByPOJO", car);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
