package com.atguigu.mvc.dao;

import com.atguigu.mvc.dao.mapper.GoodsMapper;
import com.atguigu.mvc.dao.mapper.PurchaseMapper;
import com.atguigu.mvc.dao.mapper.SalesMapper;
import com.atguigu.mvc.dao.pojo.Account;
import com.atguigu.mvc.dao.pojo.Goods;
import com.atguigu.mvc.dao.pojo.Purchase;
import com.atguigu.mvc.dao.pojo.Sales;
import com.atguigu.mvc.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Repository
public class AccountDao {
    static SqlSession sqlSession;

    public Collection<Account> getall() throws IOException{
        sqlSession = SqlSessionUtils.getSqlSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        PurchaseMapper purchaseMapper = sqlSession.getMapper(PurchaseMapper.class);
        SalesMapper salesMapper = sqlSession.getMapper(SalesMapper.class);
        List<Goods> goodsList = goodsMapper.get_goods_list();
        List<Purchase> purchaseList = purchaseMapper.Get_Purchase_List();
        List<Sales> salesList = salesMapper.get_sales_list();

        for(Goods goods : goodsList){
            System.out.println(goods.getGoodname());
        }
        return null;
    }
}
