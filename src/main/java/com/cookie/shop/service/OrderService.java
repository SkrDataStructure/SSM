package com.cookie.shop.service;

import com.cookie.shop.pojo.Cart;
import com.cookie.shop.pojo.Order;
import com.cookie.shop.pojo.OrderItem;

import java.util.List;

/*
 * @author:             HONOR
 * @date:               2023/8/31 9:50
 * @project_name:       SSM
 * @class_description:
 */
public interface OrderService {
    List<Order> selectAll(Integer id);

    List<OrderItem> selectOrderItem(Integer orderId);

    Order selectOrderById(Integer userId);

    int insert(Order order);

    int upDateOrderItem(List<Cart> carts, Integer orderId);

    void cleanShopCart(Integer user_id);

    //List<OrderItem> selectAllOrderItemByOrderId(Integer orderId);
    //int delectOrderByUserId();
}
