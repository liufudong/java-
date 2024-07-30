package com.szyh.spring6;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.szyh.spring6.biz")
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Spring6Configuration {
}
