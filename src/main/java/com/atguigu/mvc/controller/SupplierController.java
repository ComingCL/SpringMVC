package com.atguigu.mvc.controller;

import com.atguigu.mvc.dao.SupplierDao;
import com.atguigu.mvc.dao.pojo.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;

@Controller
public class SupplierController {
    @Autowired
    private SupplierDao supplierDao;
    @RequestMapping("/supplier")
    public String supplier(Model model) throws IOException {
        Collection<Supplier> supplierList = supplierDao.getall();
        model.addAttribute("supplierList", supplierList);
        return "Supplier_list";
    }
    @RequestMapping(value = "/supplier_add", method = RequestMethod.POST)
    public String supplier_add(){
        return "supplier_add";
    }
    @RequestMapping(value = "/supplier_save", method = RequestMethod.POST)
//    添加供应商
    public String supplier_save(Supplier supplier) throws IOException {
        supplierDao.save(supplier);
        return "redirect:/supplier";
    }
//    删除供应商
    @RequestMapping(value = "/supplier_del", method = RequestMethod.POST)
    public String supplier_del(Integer id) throws IOException{
        supplierDao.del(id);
        return "redirect:/supplier";
    }
//    修改供应商
    @RequestMapping(value = "/supplier_change", method = RequestMethod.POST)
    public String supplier_change(Supplier supplier) throws IOException{
        supplierDao.modify(supplier);
        return "redirect:/supplier";
    }
//    查询供应商
    @RequestMapping(value = "/supplier_search", method = RequestMethod.POST)
    public String supplier_search(String suppliername, HttpServletRequest request) throws IOException{
        supplierDao.search(suppliername);
        return "redirect:/supplier";
    }
}
