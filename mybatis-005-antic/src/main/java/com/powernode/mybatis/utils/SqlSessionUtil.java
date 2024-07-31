package com.powernode.mybatis.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal;


    static {
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml"));
        threadLocal = new ThreadLocal<>();
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    private static SqlSession getSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null) {
            sqlSession = getSqlSessionFactory().openSession();
            threadLocal.set(sqlSession);
        }
        System.out.println("sqlSession对象" + sqlSession);
        return sqlSession;
    }


    private static void close() {
        getSqlSession().close();
        threadLocal.remove();
    }
}
