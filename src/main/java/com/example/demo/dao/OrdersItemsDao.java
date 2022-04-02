package com.example.demo.dao;

import com.example.demo.model.Orders;
import com.example.demo.model.OrdersItems;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface OrdersItemsDao {

    OrdersItems insertOrdersItems(OrdersItems ordersItems);

    List<OrdersItems> selectAllOrdersItems();

    Optional<OrdersItems> selectOrdersItemsById(UUID id);

    void deleteOrdersItemsById(UUID id);

    OrdersItems updateOrdersItemsById(UUID id, OrdersItems ordersItems);
}
