package com.cookie.shop.service.impl;


import com.cookie.shop.mapper.GoodsMapper;
import com.cookie.shop.pojo.Goods;
import com.cookie.shop.service.GoodsService;
import com.cookie.shop.utils.Static;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/*
 * @author:             HONOR
 * @date:               2023/7/28 0:13
 * @project_name:       SSM
 * @class_description:
 */


@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> RandomGoods(int random) {
        return goodsMapper.randomGoods(random);
    }
    @Override
    public Goods getGoods(int id) {
        return goodsMapper.selectByPrimaryKey(id);
    }


    @Override
    public PageInfo<Goods> selectByPage(Integer pageNum) {
        // 当前页数
        int page = 1;
        if (pageNum != null){
            page = pageNum;
        }
        PageHelper.startPage(page, Static.PAGE_SIZE);
        List<Goods> goods = goodsMapper.selectAll();
        PageInfo<Goods> pageInfo = new PageInfo<>(goods, page);
        return pageInfo;
    }
}
