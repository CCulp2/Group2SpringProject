//package com.example.demo.dao;
//
//import com.example.demo.model.Orders;
//import com.example.demo.model.OrdersItems;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//
//public interface OrdersItemsDao {
//    int insertOrdersItems(UUID id, OrdersItems ordersItems);
//
//    default int insertOrdersItems(OrdersItems ordersItems) {
//        UUID id = UUID.randomUUID();
//        return insertOrdersItems(id, ordersItems);
//    }
//
//    List<OrdersItems> selectAllOrdersItems();
//
//    Optional<OrdersItems> selectOrdersItemsById(UUID id);
//
//    int deleteOrdersItemsById(UUID id);
//
//    int updateOrdersItemsById(UUID id, OrdersItems ordersItems);
//}
