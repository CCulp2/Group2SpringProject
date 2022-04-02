package com.example.demo.dao;


import com.example.demo.model.OrdersItems;
import com.example.demo.repository.OrdersItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MYSQL2")
public class OrdersItemsDataAccessService implements OrdersItemsDao{

    private OrdersItemsRepository ordersRepo;

    @Autowired
    public OrdersItemsDataAccessService(OrdersItemsRepository ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    @Override
    public OrdersItems insertOrdersItems(OrdersItems ordersItems) { return ordersRepo.save(ordersItems); }

    @Override
    public List<OrdersItems> selectAllOrdersItems() { return ordersRepo.findAll(); }

    @Override
    public Optional<OrdersItems> selectOrdersItemsById(UUID id) {
        Optional<OrdersItems> orderToReturn = ordersRepo.findById(id);
        return orderToReturn;
    }

    @Override
    public void deleteOrdersItemsById(UUID id) { ordersRepo.deleteAllById(Collections.singleton(id)); }

    @Override
    public OrdersItems updateOrdersItemsById(UUID id, OrdersItems ordersItems) {

        OrdersItems orderToUpdate = ordersRepo.getById(id);
        orderToUpdate.setOrderID(ordersItems.getOrderID());
        orderToUpdate.setProductID(ordersItems.getProductID());
        ordersRepo.save(orderToUpdate);

        return orderToUpdate;
    }

}
