import com.szyh.ldd.People;
import com.szyh.ldd.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstTest {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_001.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("user:" + user);
        Logger logger = LoggerFactory.getLogger(FirstTest.class);
        logger.info("user:"+user);

    }
    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_001.xml");
        People people = applicationContext.getBean("people", People.class);
        System.out.println("people:" + people.toString());

    }
}
