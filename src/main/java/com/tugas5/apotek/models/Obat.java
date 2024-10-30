package com.tugas5.apotek.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
