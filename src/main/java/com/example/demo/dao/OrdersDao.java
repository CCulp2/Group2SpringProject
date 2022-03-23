package com.example.demo.dao;

import com.example.demo.model.Orders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrdersDao {

    Orders insertOrder(Orders orders);

    List<Orders> selectAllOrders();

    Optional<Orders> selectOrderById(UUID id);

    void deleteOrderById(UUID id);

    Orders updateOrderById(UUID id, Orders orders);
}
