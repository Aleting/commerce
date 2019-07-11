package com.qut.po;

public class Buser {
    private Integer id;

    private String bemail;

    private String bpwd;

    private String state;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBemail() {
        return bemail;
    }

    public void setBemail(String bemail) {
        this.bemail = bemail == null ? null : bemail.trim();
    }

    public String getBpwd() {
        return bpwd;
    }

    public void setBpwd(String bpwd) {
        this.bpwd = bpwd == null ? null : bpwd.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}