package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.dao.OrdersDao;
import com.example.demo.model.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private final OrdersDao ordersDao;

    @Autowired
    public OrdersService(@Qualifier("MYSQL1") OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public Orders addOrder(Orders order) {
        return ordersDao.insertOrder(order);
    }

    public List<Orders> getAllOrders() {
        return ordersDao.selectAllOrders();
    }

    public Optional<Orders> getOrderById(UUID id) {
        return ordersDao.selectOrderById(id);
    }

    public void deleteOrder(UUID id) {
        ordersDao.deleteOrderById(id);
    }

    public Orders updateOrder(UUID id, Orders newOrder) {
        return ordersDao.updateOrderById(id, newOrder);
    }
}
