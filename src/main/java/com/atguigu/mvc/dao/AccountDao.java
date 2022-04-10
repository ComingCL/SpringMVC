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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Repository
public class AccountDao {
    static SqlSession sqlSession;

    public HashMap<Integer, Account> getall() throws IOException{
        sqlSession = SqlSessionUtils.getSqlSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        PurchaseMapper purchaseMapper = sqlSession.getMapper(PurchaseMapper.class);
        SalesMapper salesMapper = sqlSession.getMapper(SalesMapper.class);
        List<Goods> goodsList = goodsMapper.get_goods_list();
        List<Purchase> purchaseList = purchaseMapper.Get_Purchase_List();
        List<Sales> salesList = salesMapper.get_sales_list();
        HashMap<Integer, Account> accountHashMap = new HashMap<>();
        int number = 1;
        for(Goods goods : goodsList) {
            accountHashMap.put(goods.getGoodid(), new Account(number, goods.getGoodname(), 0, 0.0, 0.0, 0, goods.getAmount()));
            number += 1;
        }
        for(Purchase purchase : purchaseList){
            if(accountHashMap.containsKey(purchase.getGoodid())){
                Integer id = purchase.getGoodid();
                accountHashMap.get(id).setAccount_purchase_cost(purchase.getPurchaseprice());
                accountHashMap.get(id).setAccount_purchase(purchase.getAmount() + accountHashMap.get(id).getAccount_purchase());
            }
        }
        for(Sales sales : salesList){
            if(accountHashMap.containsKey(sales.getGoodid())){
                Integer id = sales.getGoodid();
                accountHashMap.get(id).setAccount_sale_cost(sales.getSalesprice());
                accountHashMap.get(id).setAccount_sale(sales.getAmount() + accountHashMap.get(id).getAccount_sale());
            }
        }
        for(Account account : accountHashMap.values()){
            account.setAccount_stock(account.getAccount_purchase() - account.getAccount_sale());
       }

        return accountHashMap;
    }
}
