package com.atguigu.mvc.dao;

import com.atguigu.mvc.dao.mapper.GoodsMapper;
import com.atguigu.mvc.dao.pojo.Account;
import com.atguigu.mvc.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;

@Repository
public class AccountDao {
    static SqlSession sqlSession;

    public Collection<Account> getall(HttpServletRequest request) throws IOException{
        sqlSession = SqlSessionUtils.getSqlSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        return null;
    }
}
