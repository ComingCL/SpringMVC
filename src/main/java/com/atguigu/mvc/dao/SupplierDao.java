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
//删除
    public void del(Integer id) throws IOException{
        sqlSession = SqlSessionUtils.getSqlSession();
        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
        mapper.del(id);
    }
//    修改
    public void modify(Integer supplierid,
                       String suppliername,
                       String telephone,
                       String starttime,
                       String endtime) throws IOException{
        sqlSession = SqlSessionUtils.getSqlSession();
        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
        mapper.modify(supplierid, suppliername, telephone, starttime, endtime);
    }
//    查询
    public List<Supplier> search(String suppliername) throws IOException{
        sqlSession = SqlSessionUtils.getSqlSession();
        SupplierMapper mapper = sqlSession.getMapper(SupplierMapper.class);
        return mapper.serach(suppliername);
    }
}
