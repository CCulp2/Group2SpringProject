package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Orders {

    private String orderID;
    private String orderDate;
    private String customerID;


    public Orders(@JsonProperty("orderID") String orderID,
                    @JsonProperty("orderDate") String orderDate,
                    @JsonProperty("customerID") String customerID) {
        this.orderID = orderID;
        this.orderDate= orderDate;
        this.customerID = customerID;

    }

    public String getOrderId() {
        return orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getCustomerID() {return customerID; }

}