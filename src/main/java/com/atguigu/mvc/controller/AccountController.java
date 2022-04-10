package com.atguigu.mvc.controller;

import com.atguigu.mvc.dao.AccountDao;
import com.atguigu.mvc.dao.pojo.Account;
import com.atguigu.mvc.dao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

@Controller
public class AccountController {
    @Autowired
    private AccountDao accountDao;

    @RequestMapping("/accounting_management")
    public String accounting_management(HttpServletRequest request, Model model) throws IOException {
        User user = (User) request.getSession().getAttribute("User");
        if(user == null) return "login";

        HashMap<Integer, Account> accountHashMap = accountDao.getall();
        double ans = 0.0;
        for(Account account : accountHashMap.values()){
            ans += account.getAccount_sale_cost() * account.getAccount_sale() - account.getAccount_purchase_cost() * account.getAccount_purchase();
        }
        model.addAttribute("accountHashMap", accountHashMap);
        model.addAttribute("ans", ans);
        return "accounting_management";
    }
}
