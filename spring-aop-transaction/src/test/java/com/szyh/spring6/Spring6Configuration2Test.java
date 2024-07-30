package com.szyh.spring6;

import com.szyh.spring6.biz.AccountService;
import com.szyh.spring6.biz.OrderService;
import com.szyh.spring6.user.ProductService;
import com.szyh.spring6.user.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Spring6Configuration2Test {
    @Test
    public void test1(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Spring6Configuration2.class);
        ProductService productService = applicationContext.getBean("productService", ProductService.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        productService.getProduct();
        productService.deleteProduct();
        productService.modifyProduct();
        productService.saveProduct();
        userService.getUser();
        userService.deleteUser();
        userService.modifyUser();

    }
}
