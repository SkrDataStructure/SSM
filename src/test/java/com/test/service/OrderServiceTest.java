package com.test.service;

import com.cookie.shop.pojo.Order;
import com.cookie.shop.pojo.OrderItem;
import com.cookie.shop.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/*
 * @author:             HONOR
 * @date:               2023/8/31 9:52
 * @project_name:       SSM
 * @class_description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OrderServiceTest {
    @Resource
    OrderService orderService;


    @Test
    public void SelectAllTest(){
        int id = 1;
        List<Order> orders = orderService.selectAll(id);
        System.out.println(orders);
    }

    @Test
    public void selectAllOrderIter(){
        List<Order> orders = orderService.selectAll(1);
        System.out.println(orders.get(0).getOrderItemList().get(0).getGoods().getCover());
    }

    @Test
    public void selectOrderItemTest(){
        List<OrderItem> orderItems = orderService.selectOrderItem(7116019);
        orderItems.get(0).getGoods().getId();
        System.out.println(orderItems);
    }
}
