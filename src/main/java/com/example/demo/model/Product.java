package com.example.demo.model;


import javax.persistence.*;

@Entity
@Table(name= "products")
public class Product {

    @Id
    @Column(name = "product_id")
    private Integer product_id;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "product_type")
    private String type;
    @Column(name = "quantity_in_stock")
    private int quantity_in_stock;
    @Column(name = "unit_price")
    private double unit_price;
    @Column(name = "gender")
    private String productGender;
    @Column(name = "size")
    private String productSize;
    @Column(name = "product_img_url")
    private String product_img_url;

    public Product() {

    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity_in_stock() {
        return quantity_in_stock;
    }

    public void setQuantity_in_stock(int quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getProductGender() {
        return productGender;
    }

    public void setProductGender(String productGender) {
        this.productGender = productGender;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProduct_img_url() {
        return product_img_url;
    }

    public void setProduct_img_url(String product_img_url) {
        this.product_img_url = product_img_url;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
}
