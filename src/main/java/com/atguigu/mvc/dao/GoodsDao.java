package com.atguigu.mvc.dao;

import com.atguigu.mvc.dao.mapper.GoodsMapper;
import com.atguigu.mvc.dao.pojo.Goods;
import com.atguigu.mvc.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;

@Repository
public class GoodsDao {
    private static List<Goods> goods = null;

    static SqlSession sqlSession;

    public void save(Goods goods) throws IOException {
        sqlSession = SqlSessionUtils.getSqlSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        mapper.Insert_Goods(goods);
    }

    public Collection<Goods> getall() throws IOException {
//        先这样写着吧, 必须要重新获取
        sqlSession = SqlSessionUtils.getSqlSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        goods = mapper.get_goods_list();
        return goods;
    }
}
