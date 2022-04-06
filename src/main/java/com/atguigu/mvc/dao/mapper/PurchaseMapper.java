package com.atguigu.mvc.dao.mapper;

import com.atguigu.mvc.dao.pojo.Purchase;

import java.util.List;

public interface PurchaseMapper {
    List<Purchase> Get_Purchase_List();
    int Insert_Purchase(Purchase purchase);
}
