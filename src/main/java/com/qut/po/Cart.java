package com.qut.po;

public class Cart {
    private Integer id;

    private Integer busertableId;

    private Integer goodstableId;

    private Integer shoppingnum;

    public Cart(Integer id, Integer busertableId, Integer goodstableId, Integer shoppingnum) {
        this.id = id;
        this.busertableId = busertableId;
        this.goodstableId = goodstableId;
        this.shoppingnum = shoppingnum;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusertableId() {
        return busertableId;
    }

    public void setBusertableId(Integer busertableId) {
        this.busertableId = busertableId;
    }

    public Cart() {
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