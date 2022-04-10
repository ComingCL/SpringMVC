package com.atguigu.mvc.dao.mapper;

import com.atguigu.mvc.dao.SalesDao;
import com.atguigu.mvc.dao.pojo.Sales;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalesMapper {
    List<Sales> get_sales_list();
    int Insert_Sales(Sales sales);

    void Del_Sales(@Param("salesid") Integer salesid);

    List<Sales> Search_Sale(@Param("goodid") Integer goodid);

    void modify(Sales sales);
}
