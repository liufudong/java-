package com.example.a004spirngboot.interceptor;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
//WebConfig 类（或任何你自定义的配置类）通常不需要显式注册，
// 除非它提供了Spring框架无法自动识别的组件或配置。
// 由于WebConfig 类实现了WebMvcConfigurer 接口，
// 并且Spring Boot在启动时会自动扫描并注册实现了该接口的类，
// 因此你不需要进行额外的注册步骤。
//当你将WebConfig 类放在Spring Boot的主应用类（通常带有@SpringBootApplication 注解的类）所在的包或其子包中时，Spring Boot的自动配置机制会自动发现并注册这个类。这是因为Spring Boot的@ComponentScan 注解（默认情况下，它包含在@SpringBootApplication 注解中）会自动扫描主应用类所在包及其子包中的所有组件（包括带有@Component、@Service、@Repository、@Controller、@Configuration 等注解的类）。
//因此，只要你按照以下方式组织你的代码，Spring Boot就会自动注册WebConfig 类：
//确保WebConfig 类位于Spring Boot主应用类所在的包或其子包中。
//WebConfig 类上应该有@Configuration 注解，以表明它是一个配置类。
//在WebConfig 类中，你可以通过覆盖WebMvcConfigurer 接口的方法来添加自定义的Web MVC配置，比如拦截器、消息转换器、视图解析器等。
//综上所述，对于WebConfig 这类实现了WebMvcConfigurer 接口的配置类，你不需要进行额外的注册步骤，Spring Boot会自动处理。
public class WebConfig implements WebMvcConfigurer {
    @Resource
    TokenInterceptor tokenInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns("/login", "/register", "/error","/api/testjson"); // 排除不需要拦截的路径
    }
}
