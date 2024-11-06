package com.tugas5.apotek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugas5.apotek.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer>{
    
}
