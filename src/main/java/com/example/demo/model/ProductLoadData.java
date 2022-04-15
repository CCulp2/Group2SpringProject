package com.example.demo.model;

import lombok.Data;

@Data
public class ProductLoadData {
    private String name;
    private String type;
    private int quantity_in_stock;
    private double unit_price;
    private String productGender;
    private String productSize;
    private String productImgUrl;
    private String description;
}
