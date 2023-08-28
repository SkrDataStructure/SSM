package com.test.service;

/*
 * @author:             HONOR
 * @date:               2023/7/26 18:10
 * @project_name:       SSM
 * @class_description:
 */

import com.cookie.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void test(){
        userService.login("1", "2");
    }



}
