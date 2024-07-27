import com.szh.lifecycle.Husband;
import com.szh.lifecycle.UserBean;
import com.szh.lifecycle.Wife;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RegisterBeanTest {
    @Test
    public void testBeanRegister() {
        UserBean userBean = new UserBean();
        System.out.println("userBean" + userBean);
        DefaultListableBeanFactory defaultListableBeanFactory=new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerSingleton("userBean",userBean);
        UserBean userBean1 = defaultListableBeanFactory.getBean("userBean", UserBean.class);
        System.out.println("userBean2" + userBean1);
    }
    @Test
    public void testHusbandWife() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println("wife" + wife.toString());
        Husband husband = applicationContext.getBean("husband", Husband.class);
        System.out.println("husband" + husband.toString());
    }
}
