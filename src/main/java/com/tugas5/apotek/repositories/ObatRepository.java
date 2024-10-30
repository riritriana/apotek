package com.tugas5.apotek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tugas5.apotek.models.Obat;
public interface ObatRepository extends JpaRepository<Obat,Integer> {  
    
}