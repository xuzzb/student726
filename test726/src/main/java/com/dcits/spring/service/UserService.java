package com.dcits.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author xuzzb
 * @Create 2023/2/8
 */
public class UserService {
    @Autowired
    private OrderService orderService;
    public void printInfo(){
        System.out.println(orderService);
    }
}
