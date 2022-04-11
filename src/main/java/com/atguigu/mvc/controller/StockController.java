package com.atguigu.mvc.controller;

import com.atguigu.mvc.dao.GoodsDao;
import com.atguigu.mvc.dao.StockDao;
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
import java.util.HashMap;
import java.util.List;

@Controller
public class StockController {
    @Autowired
    private StockDao stockDao;
    @RequestMapping("/stock")
    public String stock(){ return "stock";}
    @RequestMapping(value = {"/stock"}, method = RequestMethod.GET)
    public String getAllGoods(Model model, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        if(user == null) return "login";
        HashMap<Integer, Goods> stockHashMap = stockDao.getall();
        boolean isWrong = false;
        int amount = 0;
        for(Goods goods : stockHashMap.values()){
            if (goods.getAmount() < 0) {
                isWrong = true;
            }
            amount += goods.getAmount();
        }
        request.getSession().setAttribute("amount", amount);
        model.addAttribute("stockHashMap", stockHashMap);
        model.addAttribute("isWrong", isWrong);
        return "stock";
    }

    @RequestMapping(value = "/search_stock", method = RequestMethod.POST)
    public String search_stock(String goodname, Model model){
        HashMap<Integer, Goods> stockHashMap = (HashMap<Integer, Goods>) model.getAttribute("stockHashMap");
        if(stockHashMap == null) return "stock";
        HashMap<Integer, Goods> hashMap = new HashMap<>();
        int number = 1;
        for(Goods goods : stockHashMap.values()){
            if(goods.getGoodname().contains(goodname)){
                hashMap.put(number, goods);
                number += 1;
            }
        }
        model.addAttribute("stockHashMap", hashMap);
        return "stock";
    }
}
