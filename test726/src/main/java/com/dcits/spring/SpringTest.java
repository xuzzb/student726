package com.dcits.spring;


import com.dcits.spring.config.Appconfig;
import com.dcits.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author xuzzb
 * @Create 2023/2/18
 */
public class SpringTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Appconfig.class);
        UserService userService = (UserService) annotationConfigApplicationContext.getBean("userService");
        System.out.println(userService);
    }
}
