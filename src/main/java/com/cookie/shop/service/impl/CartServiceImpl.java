package com.cookie.shop.service.impl;

import com.cookie.shop.mapper.CartMapper;
import com.cookie.shop.pojo.Cart;
import com.cookie.shop.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * @author:             HONOR
 * @date:               2023/8/29 18:56
 * @project_name:       SSM
 * @class_description:
 */

@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartMapper cartMapper;

    @Override
    public void insert(Cart cart) {
        cartMapper.insert(cart);
    }

    @Override
    public List<Cart> selectAll(Integer id) {
        return cartMapper.selectByUserId(id);
    }

    @Override
    public void dropGoods(Cart shopCart) {
        cartMapper.drop(shopCart);
    }
}
