package com.atguigu.mvc.controller;

import com.atguigu.mvc.dao.PurchaseDao;
import com.atguigu.mvc.dao.mapper.PurchaseMapper;
import com.atguigu.mvc.dao.pojo.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Collection;

@Controller
public class PurchaseController {

    @Autowired
    private PurchaseDao purchaseDao;
    @RequestMapping("/Purchase")
    public String Get_All_Purchase(Model model) throws IOException {
        Collection<Purchase> purchaseList = purchaseDao.getall();
        model.addAttribute("purchaseList", purchaseList);
        return "Purchase_list";
    }
    @RequestMapping("/Purchase_add")
    public String Purchase_add(){
        return "Purchase_add";
    }
    @RequestMapping("Purchase_save")
    public String add_purchase(Purchase purchase) throws IOException{
        purchaseDao.save(purchase);
        return "redirect:/Purchase";
    }
}
