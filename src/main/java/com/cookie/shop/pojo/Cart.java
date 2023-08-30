package com.cookie.shop.pojo;

/*
 * @author:             HONOR
 * @date:               2023/8/29 12:10
 * @project_name:       SSM
 * @class_description:
 */
public class Cart {
    private Integer id;
    private Integer quantity;
    private Integer goodsId;

    public Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", goodsId=" + goodsId +
                ", goods=" + goods +
                '}';
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
