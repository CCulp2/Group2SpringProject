package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Orders {

    private UUID orderID;
    private String orderDate;
    private String customerID;


    public Orders(@JsonProperty("orderID") UUID orderID,
                    @JsonProperty("orderDate") String orderDate,
                    @JsonProperty("customerID") String customerID) {
        this.orderID = orderID;
        this.orderDate= orderDate;
        this.customerID = customerID;

    }

    public UUID getOrderId() {
        return orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getCustomerID() {return customerID; }






}