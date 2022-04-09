package com.atguigu.mvc.dao;

import com.atguigu.mvc.dao.mapper.SupplierMapper;
import com.atguigu.mvc.dao.mapper.UserMapper;
import com.atguigu.mvc.dao.pojo.Supplier;
import com.atguigu.mvc.dao.pojo.User;
import com.atguigu.mvc.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class UserDao {
    private List<User> userList = null;
    static SqlSession sqlSession;

    public void change_password(String username, String password) throws IOException {
        sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.change_password(username, password);
    }
}
