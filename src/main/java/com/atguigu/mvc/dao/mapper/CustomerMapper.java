package com.atguigu.mvc.dao.mapper;

import com.atguigu.mvc.dao.pojo.Customer;
import com.atguigu.mvc.dao.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CustomerMapper {
    List<Customer> get_customer_list();
    Customer Insert_Customers(Customer customer);
    void Delete_Customers(@Param("id") Integer id);

    void Update_Customer();
    Goods getCustomersById();
}
