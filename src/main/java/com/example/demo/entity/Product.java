package com.example.demo.entity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")

public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int inventory;
    private String productDesc;
    private String img;
    private double price;

}
