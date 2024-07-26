import com.szyh.ldd.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringComponentTest {
    @Test
    public void springComponentTest() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-componet.xml");
        Object myComponet = applicationContext.getBean("myComponet");
        System.out.println("myComponet:"+myComponet);

    }
}
