package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "products")
public class OrdersItems {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Orders_order_id")
    @Type(type = "uuid-char")
    private UUID orderID;
    @Column(name = "Products_product_id")
    private UUID productID;



    public OrdersItems()  { }

    public UUID getOrderID() { return orderID; }

    public void setOrderID(UUID orderID) { this.orderID = orderID; }

    public UUID getProductID() { return productID; }

    public void setProductID(UUID productID) { this.productID = productID; }
}
