import com.szyh.ldd.AutoWireByType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAutoWireByTypeTest {
    @Test
    public void test(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring_auto_wire_by_type.xml");
        AutoWireByType autoWireByType = applicationContext.getBean("autoWireByType", AutoWireByType.class);
        System.out.println("autoWireByType:"+autoWireByType);


        AutoWireByType autoWireByType2 = applicationContext.getBean("autoWireByType", AutoWireByType.class);
        System.out.println("autoWireByType2:"+autoWireByType2);

    }
}
