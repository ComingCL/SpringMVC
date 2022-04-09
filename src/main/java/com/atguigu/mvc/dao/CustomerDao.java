package com.atguigu.mvc.dao;

import com.atguigu.mvc.dao.mapper.CustomerMapper;
import com.atguigu.mvc.dao.mapper.GoodsMapper;
import com.atguigu.mvc.dao.pojo.Customer;
import com.atguigu.mvc.dao.pojo.Goods;
import com.atguigu.mvc.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Repository
public class CustomerDao {
    private static List<Customer> customers = null;

    static SqlSession sqlSession;

    public void save(Customer customer) throws IOException {
        sqlSession = SqlSessionUtils.getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        mapper.Insert_Customers(customer);
    }

    public Collection<Customer> getall() throws IOException {
//        先这样写着吧, 必须要重新获取
        sqlSession = SqlSessionUtils.getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        customers = mapper.get_customer_list();
        return customers;
    }
    public void delete(Integer id) throws IOException{
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        mapper.Delete_Customers(id);
    }
}
