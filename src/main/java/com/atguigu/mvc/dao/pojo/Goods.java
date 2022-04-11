package com.atguigu.mvc.dao.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Goods implements Serializable {
    private Integer goodid;
    private String goodname;
    private Integer amount;

    public Goods(Integer goodid, String goodname, Integer amount) {
        this.goodid = goodid;
        this.goodname = goodname;
        this.amount = amount;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
