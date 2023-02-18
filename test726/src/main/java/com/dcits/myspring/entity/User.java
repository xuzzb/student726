package com.dcits.myspring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author xuzzb
 * @Create 2023/2/8
 */
@Component
public class User {
    @Autowired
    private static User user;

    public void tesst2(){
        System.out.println("fdjkfdknfkd"+user);
    }
}
