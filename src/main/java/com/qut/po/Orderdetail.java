package com.qut.po;

public class Orderdetail {
    private Integer id;

    private Integer orderbasetableId;

    private Integer orderbasetable_id;

    private Integer goodstableId;

    private Integer shoppingnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderbasetableId() {
        return orderbasetableId;
    }

    public void setOrderbasetableId(Integer orderbasetableId) {
        this.orderbasetableId = orderbasetableId;
    }

    public Integer getGoodstableId() {
        return goodstableId;
    }

    public void setGoodstableId(Integer goodstableId) {
        this.goodstableId = goodstableId;
    }

    public Integer getShoppingnum() {
        return shoppingnum;
    }

    public void setShoppingnum(Integer shoppingnum) {
        this.shoppingnum = shoppingnum;
    }
}