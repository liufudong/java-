import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class InvokeTest {

    /**
     * 我们如何获取到 SystemService类的logout()、login(String,String)、login(String) 这三个方法呢？
     */
    @Test
    public void invokeTest() throws Exception {
        Class<?> aClass = Class.forName("com.szyh.invoke.SystemService");
        //获取所有字段为age的变量
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        Object object = aClass.newInstance();
        name.set(object, "张三");
        System.out.println("name:" + object.toString());
//        Constructor<?>[] constructors = aClass.getConstructors();
//        Method[] declaredMethods = aClass.getDeclaredMethods();
//        for (int i = 0; i < declaredMethods.length; i++) {
//            System.out.println("方法名:" + declaredMethods[i].getName());
//        }
//         //获取login(String username, String password)
//        Method method=aClass.getDeclaredMethod("login",String.class);
//        Object o = aClass.newInstance();
//        method.invoke(o,"张三");
//        Field[] fields = aClass.getFields();
//        for (int i = 0; i < fields.length; i++) {
//            System.out.println("Field:" + fields[i].getName());
//        }
//        Field age = aClass.getField("age");
//        age.setAccessible(true);
//        age.set(o,"50");
//        System.out.println("Object:"+o.toString());
    }
}
