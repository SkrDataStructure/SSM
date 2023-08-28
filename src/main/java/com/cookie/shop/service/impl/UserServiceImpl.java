package com.cookie.shop.service.impl;

import com.cookie.shop.mapper.UserMapper;
import com.cookie.shop.pojo.User;
import com.cookie.shop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * @author:             HONOR
 * @date:               2023/7/26 17:49
 * @project_name:       SSM
 * @class_description:
 */

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User user = userMapper.selectByUsernameUser(username);
        if (user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
}
