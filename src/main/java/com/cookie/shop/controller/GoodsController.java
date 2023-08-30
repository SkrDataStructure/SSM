package com.cookie.shop.controller;

/*
 * @author:             HONOR
 * @date:               2023/7/27 21:15
 * @project_name:       SSM
 * @class_description:
 */

import com.alibaba.druid.stat.TableStat;
import com.cookie.shop.pojo.Cart;
import com.cookie.shop.pojo.Goods;
import com.cookie.shop.pojo.User;
import com.cookie.shop.service.CartService;
import com.cookie.shop.service.GoodsService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private CartService cartService;

    private HttpServletRequest request;
    private HttpServletResponse response;

    @ModelAttribute
    public void bindRequest(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @GetMapping("/single-product")
    public String simpleProduct(Model model, Integer id) {
        List<Goods> recommendedProducts = goodsService.RandomGoods(3);
        Goods goods = goodsService.getGoods(id);
        model.addAttribute("goods", goods);
        model.addAttribute("url", request.getContextPath());
        model.addAttribute("recommendedProducts", recommendedProducts);
        return "single-product";
    }

    @GetMapping("/shop")
    public String shopList(Integer page, Model model) {
        PageInfo<Goods> pageInfo = goodsService.selectByPage(page);
        model.addAttribute("pageInfo", pageInfo);
        pageInfo.getSize();
        return "shop";
    }


    // 购物车
    @GetMapping("/add")
    @ResponseBody
    public String shopCart(Integer id, Integer quantity) {

        List<Goods> goodsList = new ArrayList<>();
        Goods goods = goodsService.selectByPrimaryKey(id);
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();


        //未登录
        if (session.getAttribute("user") == null) {
            return "false";
        }

        // 添加购物车的商品
        Integer userId = ((User)session.getAttribute("user")).getId();
        Cart cart = new Cart();
        cart.setId(userId);
        cart.setGoodsId(id);
        cart.setQuantity(quantity);
        cartService.insert(cart);
        return "true";
    }


    // 购物车
    @RequestMapping("/cart")
    public String cart(Model model) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        List<Cart> shopCart = cartService.selectAll(user.getId());
        model.addAttribute("shopCart", shopCart);
        return "/cart";
    }


    @RequestMapping("/cart/drop")
    public String dropShopCart(Integer id, Integer goodsId, Integer quantity){
        Cart dropGoods = new Cart();

        dropGoods.setId(id);
        dropGoods.setGoodsId(goodsId);
        dropGoods.setQuantity(quantity);
        cartService.dropGoods(dropGoods);

        return "redirect:/cart";
    }


}
