package com.tugas5.apotek.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas5.apotek.models.Category;
import com.tugas5.apotek.repositories.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
        
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void deleteById(Integer id){
         categoryRepository.deleteById(id);
    }

     public Category findById(Integer id){
        return categoryRepository.findById(id).orElse(null);
    }
}
