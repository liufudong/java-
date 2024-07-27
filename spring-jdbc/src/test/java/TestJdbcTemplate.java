import com.szyh.spring6.jdbc.JdbcDataSource2;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestJdbcTemplate {
    @Test
    public void testJdbcTemplate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println("jdbcTemplate:" + jdbcTemplate);
//        String sql = "insert into t_user(id,real_name,age) values(?,?,?)";
//
        String sql ="insert into t_user(id,real_name,age) values (?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        Object [] objects1= {null,"张三",20};
        Object [] objects2= {null,"张三7",30};
        Object [] objects3= {null,"张三8",40};
        Object [] objects4= {null,"张三9",50};
        batchArgs.add(objects1);
        batchArgs.add(objects2);
        batchArgs.add(objects3);
        batchArgs.add(objects4);
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println("ints:"+ Arrays.toString(ints));
//        int[] ints = jdbcTemplate.batchUpdate("INSERT INTO `t_user` VALUES (2, '张三4', 20)");
    }

    @Test
    public void testJdbcTemplate2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcDataSource2 jdbcDataSource2 = applicationContext.getBean("jdbcDataSource2", JdbcDataSource2.class);
        System.out.println("jdbcDataSource2:" + jdbcDataSource2);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(jdbcDataSource2);
        //8.7 自己new的对象如何让Spring管理
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerSingleton("jdbcTemplate", jdbcTemplate);
        JdbcTemplate jdbcTemplate1 = defaultListableBeanFactory.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println("jdbcTemplate:" + jdbcTemplate);

    }
}
