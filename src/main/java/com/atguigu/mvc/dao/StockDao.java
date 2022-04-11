package com.atguigu.mvc.dao;

import com.atguigu.mvc.dao.mapper.GoodsMapper;
import com.atguigu.mvc.dao.mapper.PurchaseMapper;
import com.atguigu.mvc.dao.mapper.SalesMapper;
import com.atguigu.mvc.dao.pojo.Goods;
import com.atguigu.mvc.dao.pojo.Purchase;
import com.atguigu.mvc.dao.pojo.Sales;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Repository
public class StockDao {
    static SqlSession sqlSession;

    public HashMap<Integer, Goods> getall() throws IOException {
        HashMap<Integer, Goods> stockHashMap = new HashMap<>();

        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        SalesMapper salesMapper = sqlSession.getMapper(SalesMapper.class);
        PurchaseMapper purchaseMapper = sqlSession.getMapper(PurchaseMapper.class);

        List<Goods> goodsList = goodsMapper.get_goods_list();
        List<Sales> salesList = salesMapper.get_sales_list();
        List<Purchase> purchaseList = purchaseMapper.Get_Purchase_List();
        int number = 1;

        HashMap<Integer, String> hashMap = new HashMap<>();
        for(Goods goods : goodsList){
            hashMap.put(goods.getGoodid(), goods.getGoodname());
        }

        for(Purchase purchase : purchaseList){
            stockHashMap.put(purchase.getGoodid(), new Goods(number, hashMap.get(purchase.getGoodid()), purchase.getAmount()));
            number += 1;
        }
        for(Sales sales : salesList){
            if(stockHashMap.containsKey(sales.getGoodid())){
                stockHashMap.get(sales.getGoodid()).setAmount(stockHashMap.get(sales.getGoodid()).getAmount() - sales.getAmount());
                number += 1;
            }else{
                stockHashMap.put(sales.getGoodid(), new Goods(number, hashMap.get(sales.getGoodid()), -sales.getAmount()));
                number += 1;
            }
        }
        return stockHashMap;
    }

}
