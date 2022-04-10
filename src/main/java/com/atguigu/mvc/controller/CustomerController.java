package com.atguigu.mvc.controller;

import com.atguigu.mvc.dao.CustomerDao;
import com.atguigu.mvc.dao.mapper.CustomerMapper;
import com.atguigu.mvc.dao.pojo.Customer;
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
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value = {"/Customer"}, method = RequestMethod.GET)
    public String getAllGoods(Model model, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        if(user == null) return "login";
        Collection<Customer> customersList = customerDao.getall();
        model.addAttribute("customersList", customersList);
        return "Customer_list";
    }

    @RequestMapping(value = "/customers_add", method = RequestMethod.POST)
    public String goods_add(){
        return "customers_add";
    }
//    添加客户
    @RequestMapping(value = "/Customers_save", method = RequestMethod.POST)
    public String addgoods(Customer customer) throws IOException {
        customerDao.save(customer);
        return "redirect:/Customer";
    }
//    删除客户
    @RequestMapping(value = "/customers_delete" ,method = RequestMethod.POST)
    public String deleteGoods(Integer id) throws IOException{
        customerDao.delete(id);
        return "redirect:/Customer";
    }
//    修改客户
    @RequestMapping(value = "/customers_modify", method = RequestMethod.POST)
    public String modifyCustomers(Customer customer) throws IOException{
        customerDao.modify(customer);
        return "redirect:/Customer";
    }
//    查询客户
    @RequestMapping(value = "/customers_serach", method = RequestMethod.POST)
    public String customer_search(String customername, Model model) throws IOException{
        List<Customer> customerList = customerDao.serach(customername);
        model.addAttribute("customersList", customerList);
        return "Customer_list";
    }
}
