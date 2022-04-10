package com.atguigu.mvc.controller;

import com.atguigu.mvc.dao.AccountDao;
import com.atguigu.mvc.dao.pojo.Account;
import com.atguigu.mvc.dao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;

@Controller
public class AccountController {
    @Autowired
    private AccountDao accountDao;

    @RequestMapping("/accounting_management")
    public String accounting_management(HttpServletRequest request) throws IOException {
        User user = (User) request.getSession().getAttribute("User");
        if(user == null) return "login";

//        Collection<Account> accountList = accountDao.getall(request);
        return "accounting_management";
    }

//    @RequestMapping("")

}
