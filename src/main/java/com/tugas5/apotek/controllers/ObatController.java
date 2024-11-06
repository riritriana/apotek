package com.tugas5.apotek.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

import com.tugas5.apotek.models.Obat;
import com.tugas5.apotek.services.CategoryService;
import com.tugas5.apotek.services.ObatService;
import com.tugas5.apotek.services.SupplierService;

// @RequestMapping("/obat")

@Controller
public class ObatController {
    @Autowired
    private ObatService obatService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/list-obat")
    public String list(Model model) {
        List<Obat> obat = obatService.getAllObat();
        model.addAttribute("obat", obat);
        model.addAttribute("category", categoryService.getAllCategory());
        model.addAttribute("supplier", supplierService.getAllsupplier());
        return "home";
    }

    @GetMapping("/update-obat/{id}")
    public String update(@PathVariable(value = "id") Integer id, Model model){
        Obat obat = obatService.findById(id);
        model.addAttribute("obat", obat);
        model.addAttribute("category", categoryService.getAllCategory());
        model.addAttribute("supplier", supplierService.getAllsupplier());
        return "update-obat";
    }

    @GetMapping("/add-obat")
    public String addobat(Model model) {
        Obat obat = new Obat();
        model.addAttribute("obat", obat);
        model.addAttribute("category", categoryService.getAllCategory());
        model.addAttribute("supplier", supplierService.getAllsupplier());

        return "add-obat";
    }

    @PostMapping("save-obat")
    public String saveobat(@ModelAttribute("obat") Obat obat) {
        obatService.save(obat);
        return "redirect:/home";
    }

    @PostMapping("/update-obat/{id}")
    public String update(@PathVariable(value = "id") Integer id, @ModelAttribute("obat") Obat obat) {
        Obat update = obatService.findById(id);
        if (update != null) {
            update.setNamaObat(obat.getNamaObat());
            update.setPrice(obat.getPrice());
            update.setDescription(obat.getDescription());
            update.setCategory(obat.getCategory());
            update.setSupplier(obat.getSupplier());
            
            obatService.save(update);
        }
        return "redirect:/home";
    }
    
    @GetMapping("delete-obat/{id}")
    public String deleteAkun(@PathVariable(value = "id") Integer id) {
        obatService.deleteById(id);
        return "redirect:/home";
    }
}
// @GetMapping("/add-obat")
// public String showAddObatForm(Model model) {
//     model.addAttribute("obat", new Obat());
//     return "add-obat";
// }

// @PostMapping("/add-obat")
// public String addObat(@ModelAttribute Obat obat) {
//     obatService.addObat(obat);
//     return "redirect:/home";
// } 

// @PostMapping("/delete-obat/{id}")
// public String deleteObat(@PathVariable Integer id) {
//     obatService.deleteObat(id);
//     return "redirect:/home";
// }

// }
