package com.cookie.shop.mapper;

import com.cookie.shop.pojo.Cart;
import com.cookie.shop.pojo.User;

import java.util.List;

/*
 * @author:             HONOR
 * @date:               2023/8/29 12:09
 * @project_name:       SSM
 * @class_description:
 */
public interface CartMapper {
    List<Cart> selectByUserId(Integer id);
    int insert(Cart newGoods);
    int drop(Cart shopCart);

    int deleteAllByUserId(Integer userId);
}
