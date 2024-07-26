import com.szyh.ldd.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtilTest {
    @Test
    public void springUtilTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_util.xml");
        MyDataSource1 myDataSource1 = applicationContext.getBean("myDataSource1", MyDataSource1.class);
        Logger logger = LoggerFactory.getLogger(SpringUtilTest.class);
        logger.info("myDataSource1:" + myDataSource1.toString());
        MyDataSource2 myDataSource2 = applicationContext.getBean("myDataSource2", MyDataSource2.class);
        logger.info("myDataSource2:" + myDataSource2.toString());

    }

    @Test
    public void vipFactory() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("factory-method.xml");
        Vip vipFactory = applicationContext.getBean("vipFactory", Vip.class);
        Logger logger = LoggerFactory.getLogger(SpringUtilTest.class);
        logger.info("myDataSource1:" + vipFactory.toString());

    }
    @Test
    public void vipFactory2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("factory-method.xml");
        Order order = applicationContext.getBean("order2", Order.class);
        Logger logger = LoggerFactory.getLogger(SpringUtilTest.class);
        logger.info("myDataSource1:" + order.toString());

    }
    @Test
    public void vipFactory3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("factory-method.xml");
        Person2 person2 = applicationContext.getBean("person2FactoryBean", Person2.class);
        Logger logger = LoggerFactory.getLogger(SpringUtilTest.class);
        logger.info("person2:" + person2.toString());

        Person2 person3 = applicationContext.getBean("person2FactoryBean", Person2.class);
        logger.info("person3:" + person3.toString());

    }
    @Test
    public void vipFactory4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("factory-method.xml");
        Person2 person2 = applicationContext.getBean("person2FactoryBean", Person2.class);
        Logger logger = LoggerFactory.getLogger(SpringUtilTest.class);
        logger.info("person2:" + person2.toString());

        Person2 person3 = applicationContext.getBean("person2FactoryBean", Person2.class);
        logger.info("person3:" + person3.toString());

    }
}
