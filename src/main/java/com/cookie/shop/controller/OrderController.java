package com.cookie.shop.controller;

/*
 * @author:             HONOR
 * @date:               2023/8/31 9:45
 * @project_name:       SSM
 * @class_description:
 */

import com.cookie.shop.pojo.Cart;
import com.cookie.shop.pojo.Order;
import com.cookie.shop.pojo.OrderItem;
import com.cookie.shop.pojo.User;
import com.cookie.shop.service.CartService;
import com.cookie.shop.service.GoodsService;
import com.cookie.shop.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.util.Date;
import java.util.List;



@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;
    @Resource
    GoodsService goodsService;
    @Resource
    private CartService cartService;

    private HttpServletRequest request;
    private HttpServletResponse response;

    @ModelAttribute
    public void bindRequest(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
    }
    @RequestMapping("/list")
    public String AllOrder(Model model){
        User user = (User) request.getSession().getAttribute("user");
        List<Order> orders = orderService.selectAll(user.getId());


        model.addAttribute("orders", orders);
        return "order_list";
    }

    @GetMapping("/iter")
    public String orderIter(Integer id, Model model){
        //订单中商品信息
        Order orderInfo = orderService.selectOrderById(id);
        List<OrderItem> orderItem = orderService.selectOrderItem(id);
        System.out.println("测试" + orderItem.get(0).getId());
        orderItem.get(0).getGoods();
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("orderItem", orderItem);
        return "iter";
    }



    //提交订单
    @PostMapping("/add")
    public String addOrder(String name, String phone, String address,  Integer paytype){
        User user = (User) request.getSession().getAttribute("user");
        List<Cart> carts = cartService.selectAll(user.getId());
        Order order = new Order();
        Integer id = Integer.parseInt(String.valueOf(System.currentTimeMillis()).substring(6, 13));
        order.setId(id);
        order.setDatetime(new Date(System.currentTimeMillis()));
        order.setUserId(user.getId());
        order.setName(name);
        order.setPhone(phone);
        order.setAddress(address);
        order.setPayType(paytype);
        order.setStatus(2);

        float price = 0;
        Integer amount = 0;
        for (Cart cart : carts) {
            amount += cart.getQuantity();
            price += cart.getQuantity() * cart.getGoods().getPrice();
        }

        order.setTotal(price);
        order.setAmount(amount);


        System.out.println(orderService.insert(order));
        System.out.println(orderService.upDateOrderItem(carts, id));

        orderService.cleanShopCart(user.getId());
        //Order order = new Order();
        cartService.cleanShopCart(user.getId());
        return "order_success";
    }


}
