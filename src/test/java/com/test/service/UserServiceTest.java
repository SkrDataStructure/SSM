package com.test.service;

/*
 * @author:             HONOR
 * @date:               2023/7/26 18:10
 * @project_name:       SSM
 * @class_description:
 */

import com.cookie.shop.pojo.Cart;
import com.cookie.shop.service.CartService;
import com.cookie.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {

    @Autowired
    UserService userService;




    @Test
    public void testSelect(){
        userService.login("1", "2");
    }

    @Test
    public void testInsert(){

    }




}
