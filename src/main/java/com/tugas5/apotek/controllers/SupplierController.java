package com.tugas5.apotek.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.tugas5.apotek.models.Supplier;
import com.tugas5.apotek.services.SupplierService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SupplierController {
    @Autowired 
    private SupplierService supplierService;

    @GetMapping("/list-supplier")
    public String list(Model model) {
        List<Supplier> supplier = supplierService.getAllsupplier();
        model.addAttribute("supplier", supplier);
        return "supplier";
    }

    @GetMapping("/update-supplier/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model){
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        return "update-supplier";
    }

    @GetMapping("/add-supplier")
    public String addsupplier(Model model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        return "add-supplier";
    }

    @PostMapping("save-supplier")
    public String savesupplier(@ModelAttribute("supplier") Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/list-supplier";
    }

    @PostMapping("/update-supplier/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute("supplier") Supplier supplier) {
        Supplier update = supplierService.findById(id);
        if (update != null) {
            update.setName(supplier.getName());
            update.setAddress(supplier.getAddress());
            update.setPhone(supplier.getPhone());

            supplierService.save(supplier);
        }
        return "redirect:/list-supplier";
    }
    
    @GetMapping("delete-supplier/{id}")
    public String deleteAkun(@PathVariable(value = "id") Integer id) {
        supplierService.deleteById(id);
        return "redirect:/list-supplier";
    }
}

