package com.atguigu.mvc.dao.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Goods implements Serializable {
    private int goodid;
    private String goodname;
    private int amount;

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

