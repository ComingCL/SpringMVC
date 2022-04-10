package com.atguigu.mvc.dao.mapper;

import com.atguigu.mvc.dao.pojo.Purchase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseMapper {
    List<Purchase> Get_Purchase_List();
    void Insert_Purchase(Purchase purchase);
    void Delete_Purchase(@Param("purchaseid") Integer purchaseid);

    void Modify_Purchase(Purchase purchase);

    List<Purchase> Serach_Purchase(@Param("goodid") Integer goodid);
}
