package com.tugas5.apotek.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    String name;
    String address;
    String phone;

}
