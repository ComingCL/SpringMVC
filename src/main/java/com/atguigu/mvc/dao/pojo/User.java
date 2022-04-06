package com.atguigu.mvc.dao.pojo;

import java.io.Serializable;
public class User implements Serializable {
    private int userid;
    private String username;
    private String password;
    private int userpower;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserpower() {
        return userpower;
    }

    public void setUserpower(int userpower) {
        this.userpower = userpower;
    }
}

