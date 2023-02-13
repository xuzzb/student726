package com.dcits.spring;

import com.dcits.spring.entity.User;
import com.dcits.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author xuzzb
 * @Create 2023/2/8
 */
public class SpringTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService)context.getBean("userService");
         userService.printInfo();
    }
}
