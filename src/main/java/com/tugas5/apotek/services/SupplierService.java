package com.tugas5.apotek.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas5.apotek.models.Supplier;
import com.tugas5.apotek.repositories.SupplierRepository;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    
    public List<Supplier> getAllsupplier(){
        return supplierRepository.findAll();
        
    }

    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public void deleteById(Integer id){
         supplierRepository.deleteById(id);
    }

     public Supplier findById(Integer id){
        return supplierRepository.findById(id).orElse(null);
    }
}
