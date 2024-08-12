package com.bjpowernode.springconfig;

import com.bjpowernode.vo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Configuration：表示当前类是 xml 配置文件的作用
 * 在这个类中有很多方法， 方法的返回值是对象。
 * 在这个方法的上面加入@Bean， 表示方法返回值的对象放入到容器中。
 * @Bean == <bean></bean>
 */
@Configuration
/**
 * @ImportResource 是导入 xml 配置，等同于 xml 文件的 resources
 * */
@ImportResource(value = {"classpath:applicationContext.xml"})
public class SpringConfig {
    @Bean
    Student getStudent() {
        return new Student(20, "张三1", 20);
    }

    @Bean(value = "makeStudent")
    Student makeStudent() {
        return new Student(20, "张三2", 20);
    }
}
