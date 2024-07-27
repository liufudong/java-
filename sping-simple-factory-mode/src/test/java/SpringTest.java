import com.szyh.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class SpringTest {
    @Test
    public void testVipFactory() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Vip vipFactory = applicationContext.getBean("vipFactory", Vip.class);
        System.out.println("vipFactory:" + vipFactory);

    }
    @Test
    public void testOrderFactory() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Order order = applicationContext.getBean("order", Order.class);
        System.out.println("order:" + order);
    }

    @Test
    public void testFactoryPerson() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = applicationContext.getBean("factoryPerson", Person.class);
        System.out.println("person:" + person);
    }

    @Test
    public void testDateFactoryBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Date date = applicationContext.getBean("dateFactoryBean", Date.class);
        System.out.println("date:" + date);
    }
    @Test
    public void testStudentBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println("student:" + student);
    }
}
