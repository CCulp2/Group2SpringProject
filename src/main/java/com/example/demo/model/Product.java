package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    private int product_id;
    private String product_name;
    private int quantity_in_stock;
    private double unit_price;
    private int Sexcategory_sex_id;
    private int Sizecategory_size_id;
    private String product_img_url;


    public Product(@JsonProperty("product_id") int product_id,
                  @JsonProperty("product_name") String product_name,
                  @JsonProperty("quantity_in_stock") int quantity_in_stock,
                @JsonProperty("unit_price") double unit_price,
                @JsonProperty("Sexcategory_sex_id") int Sexcategory_sex_id,
                @JsonProperty("Sizecategory_size_id") int Sizecategory_size_id,
                @JsonProperty("product_img_url") String product_img_url){
        this.product_id = product_id;
        this.product_name= product_name;
        this.quantity_in_stock = quantity_in_stock;
        this.unit_price = unit_price;
        this.Sexcategory_sex_id = Sexcategory_sex_id;
        this.Sizecategory_size_id = Sizecategory_size_id;
        this.product_img_url = product_img_url;

    }


    public int getProduct_id() {
        return product_id;
    }
    public String getProduct_name() {
        return product_name;
    }

    public int getQuantity_in_stock() { return quantity_in_stock; }

    public double getUnit_price() { return unit_price; }

    public int getSexcategory_sex_id() { return Sexcategory_sex_id; }

    public int getSizecategory_size_id() { return Sizecategory_size_id; }

    public String getProduct_img_url() { return product_img_url; }



//    @Column(name="product_id")
//    private int product_id;
//    @Column(name="product_name", nullable = false)
//    private String product_name;
//    @Column(name="quantity_in_stock", nullable = false)
//    private int quantity_in_stock;
//    @Column(name="unit_price", nullable = false)
//    private double unit_price;
//    @Column(name="Sexcategory_sex_id", nullable = false)
//    private int Sexcategory_sex_id;
//    @Column(name="Sizecategory_size_id", nullable = false)
//    private int Sizecategory_size_id;
//    @Column(name="product_img_url", nullable = true)
//    private String product_img_url;
//
//    public Product(int product_id, String product_name, int quantity_in_stock, double unit_price, int sexcategory_sex_id, int sizecategory_size_id, String product_img_url) {
//    }
//
//
//    public void setProduct_id(int product_id) {this.product_id = product_id;}
//
//    public void setProduct_name(String product_name) {
//        this.product_name = product_name;
//    }
//
//    public void setQuantity_in_stock(int quantity_in_stock) {
//        this.quantity_in_stock = quantity_in_stock;
//    }
//
//    public void setUnit_price(double unit_price) {
//        this.unit_price = unit_price;
//    }
//
//    public void setSexcategory_sex_id(int Sexcategory_sex_id) {
//        this.Sexcategory_sex_id = Sexcategory_sex_id;
//    }
//
//    public void setSizecategory_size_id(int Sizecategory_size_id) {
//        this.Sizecategory_size_id = Sizecategory_size_id;
//    }
//
//    public void setProduct_img_url(String product_img_url) {
//        this.product_img_url = product_img_url;
//    }
//
//
//    public int getProduct_id() {
//        return product_id;
//    }
//    public String getProduct_name() {
//        return product_name;
//    }
//
//    public int getQuantity_in_stock() { return quantity_in_stock; }
//
//    public double getUnit_price() { return unit_price; }
//
//    public int getSexcategory_sex_id() { return Sexcategory_sex_id; }
//
//    public int getSizecategory_size_id() { return Sizecategory_size_id; }
//
//    public String getProduct_img_url() { return product_img_url; }


}
