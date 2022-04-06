package com.atguigu.mvc.dao.mapper;

import com.atguigu.mvc.dao.SupplierDao;
import com.atguigu.mvc.dao.pojo.Purchase;
import com.atguigu.mvc.dao.pojo.Supplier;

import java.util.List;

public interface SupplierMapper {
    List<Supplier> Get_Supplier_List();
    int Insert_Supplier(Supplier supplier);
}
