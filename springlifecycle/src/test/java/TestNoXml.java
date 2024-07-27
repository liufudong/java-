import com.szh.config.Spring6Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestNoXml {
    @Test
    public void testNoXml(){
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(Spring6Configuration.class);
        Object user22 = applicationContext.getBean("user22");
        System.out.println("user22:"+user22);
    }
}
