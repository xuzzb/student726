package com.dcits.spring;

import com.dcits.spring.service.OrderService;
import com.dcits.spring.service.UserService;
import org.springframework.context.annotation.Bean;

/**
 * @Author xuzzb
 * @Create 2023/2/8
 */
public class AppConfig {
    @Bean
    public UserService userService(){
        return new UserService();
    }
    @Bean
    public OrderService orderService(){
        return new OrderService();
    }
}
