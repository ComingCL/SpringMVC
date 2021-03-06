package com.atguigu.mvc.dao.mapper;

import com.atguigu.mvc.dao.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    List<Goods> get_goods_list();
    Goods Insert_Goods(Goods goods);
    Integer Get_Amount();

    /**
     * 删除商品信息
     */
    void Delete_Goods(@Param("id") Integer id);
    /**
     * 修改商品信息
     */
    void Update_Goods(@Param("goodid") Integer goodid,
                      @Param("goodname") String goodname,
                      @Param("amount") Integer amount);
    /**
     * 根据名字查询商品信息
     */
    List<Goods> getGoodsByName(@Param("goodname") String goodname);

}
