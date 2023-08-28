package com.cookie.shop.mapper;

import com.cookie.shop.pojo.Recommend;
import java.util.List;

public interface RecommendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recommend row);

    Recommend selectByPrimaryKey(Integer id);

    List<Recommend> selectAll();

    int updateByPrimaryKey(Recommend row);
}