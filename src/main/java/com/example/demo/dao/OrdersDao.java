package com.example.demo.dao;

import com.example.demo.model.Orders;
import com.example.demo.model.Product;


import java.util.List;
import java.util.Optional;

public interface OrdersDao {

    Orders insertOrder(Orders orders);

    List<Orders> selectAllOrders();

    Optional<Orders> selectOrderById(Long id);

    void deleteOrderById(Long id);

    Orders updateOrderById(Long id, Orders order);

    Orders addProductToOrder(Long id, Product product);

    Orders addMultipleProductsToOrder(Long id, List<Product> products);
}
