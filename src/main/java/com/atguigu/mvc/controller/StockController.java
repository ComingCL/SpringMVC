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

@Controller
public class StockController {
    @Autowired
    private GoodsDao goodsDao;
    @RequestMapping("/stock")
    public String stock(){ return "stock";}
    @RequestMapping(value = {"/stock"}, method = RequestMethod.GET)
    public String getAllGoods(Model model, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        if(user == null) return "login";
        Collection<Goods> goodsList = goodsDao.getall(request);
        model.addAttribute("goodsList", goodsList);
        return "stock";
    }
}
