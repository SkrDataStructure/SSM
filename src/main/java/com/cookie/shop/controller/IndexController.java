package com.cookie.shop.controller;

/*
 * @author:             HONOR
 * @date:               2023/7/26 18:52
 * @project_name:       SSM
 * @class_description:
 */

import com.cookie.shop.mapper.TypeMapper;
import com.cookie.shop.pojo.Goods;
import com.cookie.shop.pojo.Type;
import com.cookie.shop.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private TypeMapper typeMapper;

    //请求首页
    @GetMapping("/index")
    public String  index(HttpServletRequest request){
        List<Goods> hotGoods = goodsService.RandomGoods(5);
        List<Goods> newGoods = goodsService.RandomGoods(5);
        request.setAttribute("hotGoods", hotGoods);
        request.setAttribute("newGoods", newGoods);
        List<Type> types = typeMapper.selectAll();
        request.setAttribute("types", types);

        return "index";
    }

    @GetMapping("/recommended")
    public String recommended(HttpServletRequest request){
        List<Goods> hotGoods = goodsService.RandomGoods(5);
        List<Goods> newGoods = goodsService.RandomGoods(5);
        request.setAttribute("hotGoods", hotGoods);
        request.setAttribute("newGoods", newGoods);
        List<Type> types = typeMapper.selectAll();
        request.setAttribute("types", types);
        return "recommended";
    }


}
