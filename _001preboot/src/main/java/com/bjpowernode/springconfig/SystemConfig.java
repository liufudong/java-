package com.bjpowernode.springconfig;

import com.bjpowernode.vo.Tiger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ComponentScan(value = {"com.bjpowernode.vo"})
//@PropertyResource 是读取 properties 属性配置文件
@PropertySource(value = {"classpath:config.properties"})

/**
 * @Configuration：表示当前类是 xml 配置文件的作用
 * 在这个类中有很多方法， 方法的返回值是对象。
 * 在这个方法的上面加入@Bean， 表示方法返回值的对象放入到容器中。
 * @Bean == <bean></bean>
 */
@Configuration
public class SystemConfig {
    @Autowired
    Tiger tiger;
}
