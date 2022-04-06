package com.atguigu.mvc.dao.mapper;

import com.atguigu.mvc.dao.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 1. 映射文件的namespace要和mapper接口的全类名保持一致
     * 2. 映射文件中SQL语句的id要和mapper接口中的方法名一致
     *
     */
    List<User> getAllUser();
    /**
     * 验证登录
     */
    User checkLogin(String username, String password);

    /**
     * 检查用户是否已经存在
     * @param username
     * @return
     */
    User checkUser(String username);
    /**
     * 添加用户信息
     * @param username
     * @param password
     * @return
     * useGenterateKeys: 使用设置自增的主键 (没必要, 数据库已经是自增的了, 如果加上反倒报错)
     * keyProperty：因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放在传输的参 数user对象的某个属性中
     */
    int insertUser(String username, String password);
}
