package com.cookie.shop.mapper;

import com.cookie.shop.pojo.Order;
import com.cookie.shop.pojo.OrderItem;
import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem row);

    List<OrderItem> selectByPrimaryKey(Integer id);

    List<OrderItem> selectAll();

    int updateByPrimaryKey(OrderItem row);

    List<OrderItem> selectAllByOrderIdInt(Integer integer);
}