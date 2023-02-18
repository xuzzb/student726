package com.dcits.spring;

import com.dcits.myspring.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author xuzzb
 * @Create 2023/2/18
 */
public class SpringTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        annotationConfigApplicationContext.getBean("userService");
    }
}
