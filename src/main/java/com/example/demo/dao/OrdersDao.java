package com.example.demo.dao;

import com.example.demo.model.Orders;
import com.example.demo.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrdersDao {

    Orders insertOrder(Orders orders);

    List<Orders> selectAllOrders();

    Optional<Orders> selectOrderById(Long id);

    void deleteOrderById(Long id);

    Orders updateOrderById(Long id, Orders order);

    Orders addProductToOrder(Long id, Product product);

    Orders addMultipleProductsToOrder(Long id, List<Product> products);
}
