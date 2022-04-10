package com.atguigu.mvc.dao.pojo;

public class Account {
    private Integer account_ID;
    private String account_name;
    private Integer account_purchase;
    private Integer account_sale;
    private Integer account_stock;

    public Integer getAccount_ID() {
        return account_ID;
    }

    public void setAccount_ID(Integer account_ID) {
        this.account_ID = account_ID;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public Integer getAccount_purchase() {
        return account_purchase;
    }

    public void setAccount_purchase(Integer account_purchase) {
        this.account_purchase = account_purchase;
    }

    public Integer getAccount_sale() {
        return account_sale;
    }

    public void setAccount_sale(Integer account_sale) {
        this.account_sale = account_sale;
    }

    public Integer getAccount_stock() {
        return account_stock;
    }

    public void setAccount_stock(Integer account_stock) {
        this.account_stock = account_stock;
    }
}
