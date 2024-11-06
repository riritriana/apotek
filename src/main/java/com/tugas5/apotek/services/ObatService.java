package com.tugas5.apotek.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas5.apotek.models.Category;
import com.tugas5.apotek.models.Obat;
import com.tugas5.apotek.models.Supplier;
import com.tugas5.apotek.repositories.CategoryRepository;
import com.tugas5.apotek.repositories.ObatRepository;
import com.tugas5.apotek.repositories.SupplierRepository;

@Service
public class ObatService {
    @Autowired
    private ObatRepository obatRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Obat> getAllObat() {
        return obatRepository.findAll();
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    public void save(Obat obat) {
        obatRepository.save(obat);
    }

    public void deleteById(Integer id) {
        obatRepository.deleteById(id);
    }

    public Obat findById(Integer id){
        return obatRepository.findById(id).orElse(null);
    }

}
