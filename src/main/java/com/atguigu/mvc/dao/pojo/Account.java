package com.atguigu.mvc.dao.pojo;

public class Account {
    private Integer account_ID;
    private String account_name;
    private Integer account_purchase;// 购买数量
    private Double account_purchase_cost;// 购买单价
    private Double account_sale_cost;
    private Integer account_sale;
    private Integer account_stock;

    public Account(Integer account_ID, String account_name, Integer account_purchase, Double account_purchase_cost, Double account_sale_cost, Integer account_sale, Integer account_stock) {
        this.account_ID = account_ID;
        this.account_name = account_name;
        this.account_purchase = account_purchase;
        this.account_purchase_cost = account_purchase_cost;
        this.account_sale_cost = account_sale_cost;
        this.account_sale = account_sale;
        this.account_stock = account_stock;
    }

    public Double getAccount_purchase_cost() {
        return account_purchase_cost;
    }

    public void setAccount_purchase_cost(Double account_purchase_cost) {
        this.account_purchase_cost = account_purchase_cost;
    }

    public Double getAccount_sale_cost() {
        return account_sale_cost;
    }

    public void setAccount_sale_cost(Double account_sale_cost) {
        this.account_sale_cost = account_sale_cost;
    }

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
