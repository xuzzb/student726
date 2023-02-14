package com.dcits.spring;

import com.dcits.spring.config.XuzzAppconfig;
import com.dcits.spring.context.XuzzApplicationContext;
import com.dcits.spring.entity.User;
import com.dcits.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author xuzzb
 * @Create 2023/2/8
 */
public class SpringTest {
    public static void main(String[] args) {
        XuzzApplicationContext xuzzApplicationContext = new XuzzApplicationContext(XuzzAppconfig.class);
        UserService userService = (UserService)xuzzApplicationContext.getBean("userService");

    }
}
