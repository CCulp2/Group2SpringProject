package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="Orders")
public class Orders {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "order_id")
    @Type(type = "uuid-char")
    private UUID orderID;
    @Column(name = "order_date", nullable = false)
    private String orderDate;
    @Column(name = "customers_customer_id", nullable = false)
    private String customerID;


    public Orders() { }

    public void setOrderID(UUID orderID) { this.orderID = orderID; }

    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public void setCustomerID(String customerID) { this.customerID = customerID; }

    public UUID getOrderID() { return orderID; }

    public String getOrderDate() { return orderDate; }

    public String getCustomerID() { return customerID; }

}