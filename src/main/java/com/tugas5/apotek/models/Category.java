package com.tugas5.apotek.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    Integer id;
    String name;
    String description;
    
    
}
