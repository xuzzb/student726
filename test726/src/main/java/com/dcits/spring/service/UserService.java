package com.dcits.spring.service;

import com.dcits.spring.anno.XuzzComponent;
import com.dcits.spring.anno.XuzzScope;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author xuzzb
 * @Create 2023/2/8
 */
@XuzzComponent("userService")
@XuzzScope("prototype")
public class UserService {
    public void printInfo(){
    }
}
