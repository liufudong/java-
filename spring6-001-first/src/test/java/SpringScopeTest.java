import com.szyh.ldd.AutoWireByType;
import com.szyh.ldd.SpringScopeBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringScopeTest {
    @Test
    public void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名11111:"+Thread.currentThread().getName());
                ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("spring-scope.xml");
                SpringScopeBean springScopeBean2 = applicationContext2.getBean("sb", SpringScopeBean.class);
                System.out.println("sb4444444:" + springScopeBean2+"线程名:"+Thread.currentThread().getName());
            }
        }).start();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringScopeBean springScopeBean = applicationContext.getBean("sb", SpringScopeBean.class);
        System.out.println("sb1:" + springScopeBean+"线程名:"+Thread.currentThread().getName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名222222:"+Thread.currentThread().getName());

                ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("spring-scope.xml");
                SpringScopeBean springScopeBean2 = applicationContext2.getBean("sb", SpringScopeBean.class);
                System.out.println("sb5555555:" + springScopeBean2+"线程名:"+Thread.currentThread().getName());
            }
        }).start();
        new Thread() {
            @Override
            public void run() {
                System.out.println("线程名33333:"+Thread.currentThread().getName());

                ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("spring-scope.xml");
                SpringScopeBean springScopeBean2 = applicationContext2.getBean("sb", SpringScopeBean.class);
                System.out.println("sb6666:" + springScopeBean2+"线程名:"+Thread.currentThread().getName());

            }
        }.start();

    }
}
