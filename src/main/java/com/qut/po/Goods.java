package com.qut.po;

import org.springframework.web.multipart.MultipartFile;

public class Goods {
    private Integer id;

    private String gname;

    private MultipartFile logoImage;

    private Double goprice;

    private Double grprice;

    private Integer gstore;

    private String gpicture;

    private Integer goodstypeId;

    private String typename;

    public MultipartFile getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(MultipartFile logoImage) {
        this.logoImage = logoImage;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Double getGoprice() {
        return goprice;
    }

    public void setGoprice(Double goprice) {
        this.goprice = goprice;
    }

    public Double getGrprice() {
        return grprice;
    }

    public void setGrprice(Double grprice) {
        this.grprice = grprice;
    }

    public Integer getGstore() {
        return gstore;
    }

    public void setGstore(Integer gstore) {
        this.gstore = gstore;
    }

    public String getGpicture() {
        return gpicture;
    }

    public void setGpicture(String gpicture) {
        this.gpicture = gpicture == null ? null : gpicture.trim();
    }

    public Integer getGoodstypeId() {
        return goodstypeId;
    }

    public void setGoodstypeId(Integer goodstypeId) {
        this.goodstypeId = goodstypeId;
    }

    public Goods(Integer id, String gname, MultipartFile logoImage, Double goprice, Double grprice, Integer gstore, String gpicture, Integer goodstypeId, String typename) {
        this.id = id;
        this.gname = gname;
        this.logoImage = logoImage;
        this.goprice = goprice;
        this.grprice = grprice;
        this.gstore = gstore;
        this.gpicture = gpicture;
        this.goodstypeId = goodstypeId;
        this.typename = typename;
    }

    public Goods() {
    }
}