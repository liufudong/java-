import com.szyh.ldd.AutoWireByName;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAutoWireByNameTest {
    @Test
    public void test(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring_auto_wire_by_name.xml");
        AutoWireByName autoWireByName = applicationContext.getBean("autoWireByName", AutoWireByName.class);
        System.out.println("autoWireByName:"+autoWireByName.toString());

    }
}
