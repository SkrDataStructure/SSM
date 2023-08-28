package com.cookie.shop.mapper;

import com.cookie.shop.pojo.Goods;
import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods row);

    Goods selectByPrimaryKey(Integer id);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods row);
    List<Goods> randomGoods(int num);
    int selectCount();
}