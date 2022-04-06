package com.atguigu.mvc.controller;

import com.atguigu.mvc.dao.SupplierDao;
import com.atguigu.mvc.dao.pojo.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "supplier_list";
    }
    @RequestMapping("/supplier_add")
    public String supplier_add(){
        return "supplier_add";
    }
    @RequestMapping("/supplier_save")
    public String supplier_save(Supplier supplier) throws IOException {
        supplierDao.save(supplier);
        return "redirect:/supplier";
    }
}
