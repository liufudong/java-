import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FirstMybatis {
    public static void main(String[] args) {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        // 2. 创建SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-config.xml"));
        // 3. 创建SqlSession对象
        SqlSession sqlSession = build.openSession();

        // 4. 执行sql
        int count = sqlSession.insert("insertCar");// 这个"insertCar"必须是sql的id
        System.out.println("插入几条数据：" + count);
        // 5. 提交（mybatis默认采用的事务管理器是JDBC，默认是不提交的，需要手动提交。）
        sqlSession.commit();
        // 6. 关闭资源（只关闭是不会提交的）
        sqlSession.close();
    }
}
