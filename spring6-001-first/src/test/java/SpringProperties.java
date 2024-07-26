import com.szyh.ldd.MyDataSource3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringProperties {
    @Test
    public void properties(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring_properties.xml");
        MyDataSource3 myDataSource3 = applicationContext.getBean("myDataSource3", MyDataSource3.class);
        System.out.println("myDataSource3:"+myDataSource3.toString());

        MyDataSource3 myDataSource4 = applicationContext.getBean("myDataSource3", MyDataSource3.class);
        System.out.println("myDataSource4:"+myDataSource4.toString());
    }
}
