import com.szh.lifecycle.User;
import com.szh.loc.MyController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LocTest {
    @Test
    public void springUtilTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        MyController myController = applicationContext.getBean("myController", MyController.class);
        System.out.println("myController" + myController);
        System.out.println("myService" + applicationContext.getBean("myService"));
        System.out.println("myRepository" + applicationContext.getBean("myRepository"));
        System.out.println("myComponent" + applicationContext.getBean("myComponent"));
    }


}
