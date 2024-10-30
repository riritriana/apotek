package com.tugas5.apotek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tugas5.apotek.models.Obat;
import com.tugas5.apotek.services.ObatService;

@Controller
@RequestMapping("/obat")
public class ObatController {
    @Autowired
private ObatService obatService;

@GetMapping("/add-obat")
public String showAddObatForm(Model model) {
    model.addAttribute("obat", new Obat());
    return "add-obat";
}

@PostMapping("/add-obat")
public String addObat(@ModelAttribute Obat obat) {
    obatService.addObat(obat);
    return "redirect:/home";
} 

@PostMapping("/delete-obat/{id}")
public String deleteObat(@PathVariable Integer id) {
    obatService.deleteObat(id);
    return "redirect:/home";
}

}
