package com.tugas5.apotek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugas5.apotek.models.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    
} 
