package com.atguigu.mvc.dao.mapper;

import com.atguigu.mvc.dao.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    List<Goods> get_goods_list();
    Goods Insert_Goods(Goods goods);

    /**
     * 删除商品信息
     * @param id
     */
    void Delete_Goods(@Param("id") Integer id);
    /**
     * 修改商品信息
     */
    void Update_Goods();
    /**
     * 根据名字查询商品信息
     */
    Goods getGoodsById();
}
