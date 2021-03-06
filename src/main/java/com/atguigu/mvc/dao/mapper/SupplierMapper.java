package com.atguigu.mvc.dao.mapper;

import com.atguigu.mvc.dao.SupplierDao;
import com.atguigu.mvc.dao.pojo.Purchase;
import com.atguigu.mvc.dao.pojo.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMapper {
    List<Supplier> Get_Supplier_List();
    int Insert_Supplier(Supplier supplier);

    void del(@Param("id") Integer id);

    void modify(@Param("supplierid") Integer supplierid,
                @Param("suppliername") String suppliername,
                @Param("telephone") String telephone,
                @Param("starttime") String starttime,
                @Param("endtime") String endtime);

    List<Supplier> serach(@Param("suppliername") String suppliername);
}
