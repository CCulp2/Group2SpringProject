package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderCustomerMapper {
    Long customerID;
    List<Product> productsToAdd;
}
