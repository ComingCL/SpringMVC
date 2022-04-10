package com.atguigu.mvc.controller;

import com.atguigu.mvc.dao.PurchaseDao;
import com.atguigu.mvc.dao.mapper.PurchaseMapper;
import com.atguigu.mvc.dao.pojo.Purchase;
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
public class PurchaseController {

    @Autowired
    private PurchaseDao purchaseDao;
    @RequestMapping("/Purchase")
    public String Get_All_Purchase(Model model, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        if(user == null) return "login";
        Collection<Purchase> purchaseList = purchaseDao.getall();
        model.addAttribute("purchaseList", purchaseList);
        return "Purchase_list";
    }
    @RequestMapping("/Purchase_add")
    public String Purchase_add(){
        return "Purchase_add";
    }
//    添加订单
    @RequestMapping("Purchase_save")
    public String add_purchase(Purchase purchase) throws IOException{
        purchaseDao.save(purchase);
        return "redirect:/Purchase";
    }
//    删除订单
    @RequestMapping("Purchase_delete")
    public String delete_purchase(Integer purchaseid) throws IOException{
        purchaseDao.del(purchaseid);
        return "redirect:/Purchase";
    }
//    修改订单
    @RequestMapping(value = "/Purchase_modify", method = RequestMethod.POST)
    public String Purchase_modify(Purchase purchase) throws IOException{
        purchaseDao.modify(purchase);
        return "redirect:/Purchase";
    }
//    查询订单
    @RequestMapping(value = "/Purchase_search", method = RequestMethod.POST)
    public String Purchase_search(String purchasename, Model model) throws IOException{
        List<Purchase> purchaseList = purchaseDao.search(purchasename);
        model.addAttribute("purchaseList", purchaseList);
        return "Purchase_list";
    }
}
