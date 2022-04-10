package com.atguigu.mvc.controller;

import com.atguigu.mvc.dao.GoodsDao;
import com.atguigu.mvc.dao.SalesDao;
import com.atguigu.mvc.dao.pojo.Goods;
import com.atguigu.mvc.dao.pojo.Sales;
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
public class SaleController {
    @Autowired
    private SalesDao salesDao;

    @RequestMapping(value = "/Sales", method = RequestMethod.GET)
    public String getAllGoods(Model model, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        if(user == null) return "login";
        Collection<Sales> salesList = salesDao.getall();
        model.addAttribute("salesList", salesList);
        return "Sales_list";
    }

    @RequestMapping(value = "/sales_add", method = RequestMethod.POST)
    public String sales_add(){
        return "Sales_add";
    }

    @RequestMapping(value = "/sales_save", method = RequestMethod.POST)
    public String addsales(Sales sales) throws IOException {
        salesDao.save(sales);
        return "redirect:/Sales";
    }
}
