package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.example.demo.dao.OrdersItemsDao;
import com.example.demo.model.OrdersItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrdersItemsService {

    private final OrdersItemsDao ordersItemsDao;

    @Autowired
    public OrdersItemsService(@Qualifier("MYSQL2") OrdersItemsDao ordersItemsDao) { this.ordersItemsDao = ordersItemsDao; }

    public OrdersItems addOrdersItems(OrdersItems ordersItems) {
        return ordersItemsDao.insertOrdersItems(ordersItems);
    }

    public List<OrdersItems> getAllOrdersItems() {
        return ordersItemsDao.selectAllOrdersItems();
    }

    public Optional<OrdersItems> getOrdersItemsById(UUID id) {
        return ordersItemsDao.selectOrdersItemsById(id);
    }

    public void deleteOrdersItems(UUID id) {
        ordersItemsDao.deleteOrdersItemsById(id);
    }

    public OrdersItems updateOrdersItems(UUID id, OrdersItems newOrdersItems) { return ordersItemsDao.updateOrdersItemsById(id, newOrdersItems); }
}
