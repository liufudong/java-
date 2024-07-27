import com.szh.lifecycle.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringlifecycleTest {
    @Test
    public void springUtilTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("4.使用Bean:"+user.toString());
        // 只有正常关闭spring容器才会执行销毁方法
        ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) applicationContext;
        classPathXmlApplicationContext.close();

    }


}
