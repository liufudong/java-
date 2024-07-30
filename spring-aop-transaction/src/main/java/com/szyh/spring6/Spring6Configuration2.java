package com.szyh.spring6;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.szyh.spring6.user")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Spring6Configuration2 {
}
