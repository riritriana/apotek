package com.tugas5.apotek.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@Entity
public class Obat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String namaObat;
    Long price;
    String description;

    @ManyToOne
     @JoinColumn(name = "category_id" , referencedColumnName = "id")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "supplier_id" , referencedColumnName = "id") 
    private Supplier supplier;
}
