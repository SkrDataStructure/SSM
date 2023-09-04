package com.cookie.shop.service;

import com.cookie.shop.pojo.Cart;

import javax.annotation.Resource;
import java.util.List;

/*
 * @author:             HONOR
 * @date:               2023/8/29 18:55
 * @project_name:       SSM
 * @class_description:
 */
public interface CartService{
    void insert(Cart cart);

    List<Cart> selectAll(Integer id);

    void dropGoods(Cart cart);

    void cleanShopCart(Integer id);
}
