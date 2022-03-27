package com.example.demo.dao;

import com.example.demo.model.Orders;
import com.example.demo.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MYSQL1")
public class OrdersDataAccessService implements OrdersDao{

    private OrdersRepository ordersRepo;

    @Autowired
    public OrdersDataAccessService(OrdersRepository ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    @Override
    public Orders insertOrder(Orders order) { return ordersRepo.save(order); }

    @Override
    public List<Orders> selectAllOrders() { return ordersRepo.findAll(); }

    @Override
    public Optional<Orders> selectOrderById(UUID id) {
        Optional<Orders> orderToReturn = ordersRepo.findById(id);
        return orderToReturn;
    }

    @Override
    public void deleteOrderById(UUID id) {
        ordersRepo.deleteAllById(Collections.singleton(id));
    }

    @Override
    public Orders updateOrderById(UUID id, Orders order) {
        Orders orderToUpdate = ordersRepo.getById(id);
        orderToUpdate.setOrderDate(order.getOrderDate());
        orderToUpdate.setCustomerID(order.getCustomerID());
        ordersRepo.save(orderToUpdate);

        return orderToUpdate;
    }


}
