package com.dcits.myspring;

import com.dcits.myspring.entity.User;
import com.dcits.myspring.service.OrderService;
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
    @Bean
    public User user(){
        return new User();
    }
}
