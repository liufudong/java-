package com.szyh.car;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml"));
    }
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
