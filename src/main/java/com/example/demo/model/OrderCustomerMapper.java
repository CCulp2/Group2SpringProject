package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderCustomerMapper {
    int customerID;
    List<Product> productsToAdd;
}
