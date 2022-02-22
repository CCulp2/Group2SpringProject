package com.example.demo.model;

import java.math.BigDecimal;

public class Product {
    int id;
    Gender gender;
    Size size;
    String itemName;
    int quantityInStock;
    BigDecimal unitPrice;
    BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    /* NOTE: BigDecimal means that we have to use UNFORMATTED NUMBERS
        when we pass or retrieve. This also means that formatting needs to be done
        on the client side. For instance:

        Human readable Price: $19.99
        BigDecimal Price: 1999
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
