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
        for(Goods goods : stockHashMap.values()){
            if (goods.getAmount() < 0) {
                isWrong = true;
                break;
            }
        }
        model.addAttribute("stockHashMap", stockHashMap);
        model.addAttribute("isWrong", isWrong);
        return "stock";
    }
}
