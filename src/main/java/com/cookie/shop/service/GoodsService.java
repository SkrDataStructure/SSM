package com.cookie.shop.service;

import com.cookie.shop.pojo.Goods;
import com.github.pagehelper.PageInfo;

import java.util.List;

/*
 * @author:             HONOR
 * @date:               2023/7/28 0:12
 * @project_name:       SSM
 * @class_description:
 */
public interface GoodsService {

    List<Goods> RandomGoods(int random);

    Goods getGoods(int id);

    PageInfo<Goods> selectByPage(Integer pageNum);
}
