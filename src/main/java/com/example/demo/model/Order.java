package com.example.demo.model;

import java.util.ArrayList;
import java.time;

public class Order {
  int id; 
  ArrayList<Product> Product = new ArrayList<Product>();
  LocalDateTime orderDate;
}

  public void setProduct(Product product){
    this.product = product;
  }

  public void getProduct(){
    return this.Product;
  }

  public void getDateTime(){
    return this.DateTime;
  }
