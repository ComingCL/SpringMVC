package com.atguigu.mvc.dao.pojo;

public class Sales {
    private int salesid;
    private int customerid;
    private int goodid;
    private double salesprice;
    private String salestime;
    private int amount;
    private int isreturn;

    public int getSalesid() {
        return salesid;
    }

    public void setSalesid(int salesid) {
        this.salesid = salesid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public double getSalesprice() {
        return salesprice;
    }

    public void setSalesprice(double salesprice) {
        this.salesprice = salesprice;
    }

    public String getSalestime() {
        return salestime;
    }

    public void setSalestime(String salestime) {
        this.salestime = salestime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIsreturn() {
        return isreturn;
    }

    public void setIsreturn(int isreturn) {
        this.isreturn = isreturn;
    }
}
