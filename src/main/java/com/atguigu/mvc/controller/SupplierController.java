package com.atguigu.mvc.controller;

import com.atguigu.mvc.dao.SupplierDao;
import com.atguigu.mvc.dao.pojo.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String supplier_save(Supplier supplier) throws IOException {
        supplierDao.save(supplier);
        return "redirect:/supplier";
    }
}
