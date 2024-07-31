package com.szyh.bank.serivce;

import com.szyh.bank.pojo.Tact;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Service {
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

    public static Tact selectOne(String actno) {
        SqlSession sqlSession = getSqlSession();
        Tact tact = sqlSession.selectOne("com.szyh.bank.pojo.Tact.selectOne", actno);
        System.out.println("tact" + tact.toString());
        return tact;
    }


    private static void close() {
        getSqlSession().close();
//        threadLocal.set(null);
        threadLocal.remove();
    }

    public static int update(Tact actno) {
        SqlSession sqlSession = getSqlSession();
        int count = sqlSession.update("com.szyh.bank.pojo.Tact.update", actno);
        System.out.println("count" + count);
        return count;
    }

    public static int toForm(String toActno, String fromActno, double money) {
        Tact toTact = selectOne(toActno);
        Tact fromTact = selectOne(fromActno);
        toTact.setBalance(toTact.getBalance() - money);
        fromTact.setBalance(fromTact.getBalance() + money);
        int count = update(toTact);
        //模拟异常
        int i = 1 / 0;
        count += update(fromTact);
        if (count == 2) {
          //只有当都成功才commit
            getSqlSession().commit();
            System.out.println("转账成功");
        } else {
            System.out.println("转账失败");
        }
        close();
        return count;
    }
}
