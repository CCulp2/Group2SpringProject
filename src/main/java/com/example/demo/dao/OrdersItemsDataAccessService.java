//package com.example.demo.dao;
//
//
//import com.example.demo.model.OrdersItems;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository("MYSQL2")
//public class OrdersItemsDataAccessService implements OrdersItemsDao{
//
//    private final JdbcTemplate jdbcTemplate;
//    @Autowired
//    public OrdersItemsDataAccessService(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public int insertOrdersItems(UUID orderId, OrdersItems ordersItems) {
//        String sql = "insert into Orders_items (order_orders_id, Product_product_id)  values" +
//                "('" + orderId +"'" +
//                ", '" + ordersItems.getproductID() + "');";
//        jdbcTemplate.update(sql);
//        return 0;
//
//    }
//
//    @Override
//    public List<OrdersItems> selectAllOrdersItems() {
//
//        String sql = "select Orders_order_id, Products_product_id from Orders_items;";
//        List<OrdersItems> ordersItems = jdbcTemplate.query(sql, (resultSet, i) -> {
//            String OrderId = resultSet.getString("Orders_order_id");
//            String ProductId = resultSet.getString("Products_product_id");
//            return new OrdersItems(OrderId, ProductId);
//        });
//        return ordersItems;
//
//    }
//
//    @Override
//    public Optional<OrdersItems> selectOrdersItemsById(UUID id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public int deleteOrdersItemsById(UUID id) {
//        return 0;
//    }
//
//    @Override
//    public int updateOrdersItemsById(UUID id, OrdersItems ordersItems) {
//        return 0;
//    }
//
//}
