package com.cookie.shop.controller;

/*
 * @author:             HONOR
 * @date:               2023/7/27 21:15
 * @project_name:       SSM
 * @class_description:
 */

import com.cookie.shop.pojo.Goods;
import com.cookie.shop.service.GoodsService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @GetMapping("/single-product")
    public String simpleProduct(Model model, Integer id){
        List<Goods> recommendedProducts = goodsService.RandomGoods(3);
        Goods goods = goodsService.getGoods(id);
        model.addAttribute("goods", goods);
        model.addAttribute("recommendedProducts", recommendedProducts);
        return "single-product";
    }

    @GetMapping("/shop")
    public String shopList(Integer page, Model model){
        PageInfo<Goods> pageInfo = goodsService.selectByPage(page);
        model.addAttribute("pageInfo", pageInfo);
        pageInfo.getSize();
        return "shop";
    }

    @GetMapping ("/cart")
    public String shopCart(Integer id, Integer quantity){

        return "cart";
    }
}
