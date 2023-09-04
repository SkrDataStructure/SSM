package com.cookie.shop.service;

import com.cookie.shop.pojo.User;

/*
 * @author:             HONOR
 * @date:               2023/7/26 17:49
 * @project_name:       SSM
 * @class_description:
 */
public interface UserService {

    User login(String username, String password);

    int register(User user);
}
