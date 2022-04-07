package com.atguigu.mvc.controller;

import com.atguigu.mvc.dao.GoodsDao;
import com.atguigu.mvc.dao.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Collection;

@Controller
public class GoodsController {
    @Autowired
    private GoodsDao goodsDao;

    @RequestMapping(value = {"/Goods"}, method = RequestMethod.GET)
    public String getAllGoods(Model model) throws IOException {
        Collection<Goods> goodsList = goodsDao.getall();
        model.addAttribute("goodsList", goodsList);
        return "Goods_list";
    }

    @RequestMapping(value = "/goods_add", method = RequestMethod.POST)
    public String goods_add(){
        return "goods_add";
    }
    @RequestMapping(value = "/Goods_save", method = RequestMethod.POST)
    public String addgoods(Goods goods) throws IOException {
        goodsDao.save(goods);
        return "redirect:/Goods";
    }
}
