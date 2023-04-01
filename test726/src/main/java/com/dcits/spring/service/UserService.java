package com.dcits.spring.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @Author xuzzb
 * @Create 2023/2/8
 */
@Component("userService")
public class UserService implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("此处销毁bean");
    }
}
