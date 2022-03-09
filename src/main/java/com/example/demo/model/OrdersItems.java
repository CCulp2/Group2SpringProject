package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdersItems {
    private String orderID;
    private String productID;



    public OrdersItems(@JsonProperty("orderID") String orderID,
                  @JsonProperty("productID") String productID) {
        this.orderID = orderID;
        this.productID = productID;

    }

    public String getOrderId() {
        return orderID;
    }

    public String getproductID() {return productID; }

}
