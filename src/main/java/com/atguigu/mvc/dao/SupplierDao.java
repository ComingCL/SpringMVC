package com.atguigu.mvc.dao;

import com.atguigu.mvc.dao.mapper.PurchaseMapper;
import com.atguigu.mvc.dao.mapper.SupplierMapper;
import com.atguigu.mvc.dao.pojo.Purchase;
import com.atguigu.mvc.dao.pojo.Supplier;
import com.atguigu.mvc.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Repository
public class SupplierDao {
    private List<Supplier> suppliers = null;
    static SqlSession sqlSession;
    public void save(Supplier supplier) throws IOException {
        sqlSession = SqlSessionUtils.getSqlSession();
        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
        mapper.Insert_Supplier(supplier);
    }

    public Collection<Supplier> getall() throws IOException {
        sqlSession = SqlSessionUtils.getSqlSession();
        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
        suppliers = mapper.Get_Supplier_List();
        return suppliers;
    }
}
