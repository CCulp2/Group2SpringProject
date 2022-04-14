package com.example.demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@Table(name= "products")
public class Product {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer product_id;
    private String name;
    private String type;
    private int quantity_in_stock;
    private double unit_price;
    private String productGender;
    private String productSize;
    private String productImgUrl;
    private String description;
}
