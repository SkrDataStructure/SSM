package com.test.service;

/*
 * @author:             HONOR
 * @date:               2023/8/29 19:16
 * @project_name:       SSM
 * @class_description:
 */

import com.cookie.shop.pojo.Cart;
import com.cookie.shop.pojo.Goods;
import com.cookie.shop.service.CartService;
import com.cookie.shop.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GoodsServiceTest {

    @Autowired
    CartService cartService;

    @Autowired
    GoodsService goodsService;

    @Test
    public void testCart(){
        List<Cart> carts = cartService.selectAll(1);
        Cart cart = carts.get(1);
        Integer id = cart.getGoods().getId();
        System.out.println(carts);
    }

    @Test
    public void testInsert(){
        Cart cart = new Cart();
        cart.setQuantity(123);
        cart.setGoodsId(999);
        cart.setId(123321);
        cartService.insert(cart);
    }

    @Test
    public void goodsServiceTest(){
        //Goods goods = goodsService.selectByPrimaryKey("1");
    }

    @Test
    public void shopCartDrop(){
        Cart cart = new Cart();
        cart.setId(123321);
        cart.setGoodsId(999);
        cart.setQuantity(123);
        cartService.dropGoods(cart);
    }

}
