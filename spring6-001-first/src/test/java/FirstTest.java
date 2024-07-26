import com.szyh.ldd.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstTest {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_001.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("user:" + user);
    }
}
