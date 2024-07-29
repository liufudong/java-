package com.szyh.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SecondMybatis {
    public static void main(String[] args) {
        SqlSession sqlSession=null;
        try {
            // 1. 创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 2. 创建SqlSessionFactory对象
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            // 3. 创建SqlSession对象
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
}
