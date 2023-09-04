package com.cookie.shop.service.impl;

import com.cookie.shop.mapper.OrderItemMapper;
import com.cookie.shop.mapper.OrderMapper;
import com.cookie.shop.pojo.Cart;
import com.cookie.shop.pojo.Order;
import com.cookie.shop.pojo.OrderItem;
import com.cookie.shop.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * @author:             HONOR
 * @date:               2023/8/31 9:50
 * @project_name:       SSM
 * @class_description:
 */


@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;

    @Resource
    OrderItemMapper orderItemMapper;



    //查询当前用户所有订单
    @Override
    public List<Order> selectAll(Integer id) {
        return orderMapper.selectAll(id);
    }

    @Override
    public List<OrderItem> selectOrderItem(Integer orderId) {
        List<OrderItem> orderList = orderItemMapper.selectAllByOrderIdInt(orderId);
        return orderList;
    }

    @Override
    public Order selectOrderById(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int upDateOrderItem(List<Cart> carts, Integer orderId) {
        int i = 0;
        OrderItem orderItem = new OrderItem();
        for (Cart cart : carts) {
            orderItem.setPrice(cart.getGoods().getPrice());
            orderItem.setAmount(cart.getQuantity());
            orderItem.setGoodsId(cart.getGoodsId());
            orderItem.setGoodsId(cart.getGoodsId());
            orderItem.setOrderId(orderId);
            i += orderItemMapper.insert(orderItem);
        }
        return i;
    }

    @Override
    public void cleanShopCart(Integer user_id) {

    }

    //@Override
    //public List<OrderItem> selectAllOrderItemByOrderId(Integer orderId) {
    //    List<OrderItem> orderItems = orderItemMapper.selectAllByOrderIdInt(orderId);
    //    return orderItems;
    //}

}
