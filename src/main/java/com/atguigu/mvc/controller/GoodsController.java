package com.atguigu.mvc.controller;

import com.atguigu.mvc.dao.GoodsDao;
import com.atguigu.mvc.dao.pojo.Goods;
import com.atguigu.mvc.dao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    private GoodsDao goodsDao;

    @RequestMapping(value = {"/Goods"}, method = RequestMethod.GET)
    public String getAllGoods(Model model, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        if(user == null) return "login";
        Collection<Goods> goodsList = goodsDao.getall(request);
        model.addAttribute("goodsList", goodsList);

        return "Goods_list";
    }

    @RequestMapping(value = "/goods_add", method = RequestMethod.POST)
    public String goods_add(){
        return "goods_add";
    }
//    商品增加
    @RequestMapping(value = "/Goods_save", method = RequestMethod.POST)
    public String addgoods(Goods goods) throws IOException {
        goodsDao.save(goods);
        return "redirect:/Goods";
    }
//    商品删除
    @RequestMapping(value = "/goods_delete" ,method = RequestMethod.POST)
    public String deleteGoods(Integer id) throws IOException{
        goodsDao.delete(id);
        return "redirect:/Goods";
    }
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(Integer amount, HttpServletRequest request){
        request.getSession().setAttribute("totamount", amount);
        return "system_management";
    }

//    商品修改
    @RequestMapping(value = "/goods_change", method = RequestMethod.POST)
    public String goods_change(Integer goodid, String goodname, Integer amount){
        goodsDao.modify(goodid, goodname, amount);
        return "redirect:/Goods";
    }
//    商品查询
    @RequestMapping(value = "/goods_search", method = RequestMethod.POST)
    public String goods_search(String goodname, Model model) throws IOException{
        List<Goods> goodsList = goodsDao.Serach(goodname);
        model.addAttribute("goodsList", goodsList);
        return "Goods_list";
    }

}