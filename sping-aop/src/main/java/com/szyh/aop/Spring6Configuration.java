package com.szyh.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.szyh.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Spring6Configuration {
}
