package com.atguigu.mvc.dao;

import com.atguigu.mvc.controller.PurchaseController;
import com.atguigu.mvc.dao.mapper.GoodsMapper;
import com.atguigu.mvc.dao.mapper.PurchaseMapper;
import com.atguigu.mvc.dao.pojo.Goods;
import com.atguigu.mvc.dao.pojo.Purchase;
import com.atguigu.mvc.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Repository
public class PurchaseDao {
    private List<Purchase> purchases = null;
    static SqlSession sqlSession;
    public void save(Purchase purchase) throws IOException {
        sqlSession = SqlSessionUtils.getSqlSession();
        PurchaseMapper mapper = sqlSession.getMapper(PurchaseMapper.class);
        mapper.Insert_Purchase(purchase);
    }

    public Collection<Purchase> getall() throws IOException {
//        先这样写着吧, 必须要重新获取
        sqlSession = SqlSessionUtils.getSqlSession();
        PurchaseMapper mapper = sqlSession.getMapper(PurchaseMapper.class);
        purchases = mapper.Get_Purchase_List();
        return purchases;
    }
    public void del(Integer purchaseid) throws IOException{
        PurchaseMapper mapper = sqlSession.getMapper(PurchaseMapper.class);
        mapper.Delete_Purchase(purchaseid);
    }
    public void modify(Purchase purchase) throws IOException{
        PurchaseMapper mapper = sqlSession.getMapper(PurchaseMapper.class);
        mapper.Modify_Purchase(purchase);
    }
    public List<Purchase> search(Integer goodid) throws IOException{
        PurchaseMapper mapper = sqlSession.getMapper(PurchaseMapper.class);
        return mapper.Serach_Purchase(goodid);
    }
}
