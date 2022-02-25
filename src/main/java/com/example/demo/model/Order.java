package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
  private int id;
  private ArrayList<Product> ProductList = new ArrayList<Product>();
  private LocalDateTime orderDate;

  public Order(int id, LocalDateTime orderDate, ArrayList<Product> ProductList) {
    this.id = id;
    this.orderDate = LocalDateTime.now();
    this.ProductList = ProductList;
  }

  public LocalDateTime getOrderDate() {
    return orderDate;
  }

  
}
