package com.atguigu.mvc.dao;

import com.atguigu.mvc.dao.mapper.PurchaseMapper;
import com.atguigu.mvc.dao.mapper.SalesMapper;
import com.atguigu.mvc.dao.pojo.Purchase;
import com.atguigu.mvc.dao.pojo.Sales;
import com.atguigu.mvc.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
@Repository
public class SalesDao {
    private List<Sales> sales = null;
    static SqlSession sqlSession;
    public void save(Sales sales) throws IOException {
        sqlSession = SqlSessionUtils.getSqlSession();
        SalesMapper mapper = sqlSession.getMapper(SalesMapper.class);
        mapper.Insert_Sales(sales);
    }

    public Collection<Sales> getall() throws IOException {
        sqlSession = SqlSessionUtils.getSqlSession();
        SalesMapper mapper = sqlSession.getMapper(SalesMapper.class);
        sales = mapper.get_sales_list();
        return sales;
    }

    public void Delete(Integer salesid) throws IOException{
        SalesMapper mapper = sqlSession.getMapper(SalesMapper.class);
        mapper.Del_Sales(salesid);
    }

    public List<Sales> Search(Integer goodid) throws IOException{
        SalesMapper mapper = sqlSession.getMapper(SalesMapper.class);
        return mapper.Search_Sale(goodid);
    }
}
