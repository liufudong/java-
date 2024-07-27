import com.szh.a.A;
import com.szh.autowired.UserResourceService;
import com.szh.autowired.UserService;
import com.szh.loc.MyController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ATest {
    @Test
    public void springUtilTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring3.xml");
//        A myController = applicationContext.getBean("a", A.class);
//        System.out.println("a" + myController);
        System.out.println("b" + applicationContext.getBean("b"));
        System.out.println("c" + applicationContext.getBean("c"));
        System.out.println("d" + applicationContext.getBean("d"));
    }

    @Test
    public void testAutowired() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring3.xml");
        Object user = applicationContext.getBean("user");
        System.out.println("user:" + user.toString());

    }
    @Test
    public void testUser() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring4.xml");
        UserResourceService userService = applicationContext.getBean("userResourceService", UserResourceService.class);
        userService.insert();
        System.out.println("userService:"+userService.toString());

    }
}
