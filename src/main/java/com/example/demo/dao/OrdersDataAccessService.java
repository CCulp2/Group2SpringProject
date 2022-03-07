package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;

import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MYSQL1")
public class OrdersDataAccessService implements OrdersDao{

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public OrdersDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public int insertOrder(UUID id, Orders orders) {
        //String idGenerator = UUID.randomUUID().toString();
        String sql = "insert into Orders (order_id, order_date, Customers_customer_ID)  values" +
                "('" + id +"'" +
                ", '" + orders.getOrderDate() +"'" +
                ", '" + orders.getCustomerID() + "');";
        jdbcTemplate.update(sql);
        return 0;

    }

    @Override
    public List<Orders> selectAllOrders() {

        String sql = "select order_id, order_date, Customers_customer_id from Orders;";
        List<Orders> orders = jdbcTemplate.query(sql, (resultSet, i) -> {
            String orderId = resultSet.getString("order_id");
            UUID id = UUID.fromString(orderId);
            String orderDate = resultSet.getString("order_date");
            String CustomerID = resultSet.getString("Customers_customer_id");
            return new Orders(id, orderDate, CustomerID);
        });
        return orders;

    }

    @Override
    public List<Orders> selectOrderById(UUID id) {
        String sql = "select order_id, order_date, Customers_customer_id from Orders where order_id = '" + id +"';";
        List<Orders> order = jdbcTemplate.query(sql, (resultSet, i) -> {
            String orderDate = resultSet.getString("order_date");
            String CustomerID = resultSet.getString("Customers_customer_id");
            return new Orders(id, orderDate, CustomerID);
        });
        return order;
    }

    @Override
    public int deleteOrderById(UUID id) {
        String sql = "delete from Orders where order_id = '" + id + "';";
        jdbcTemplate.update(sql);
        return 0;
    }

    @Override
    public void updateOrderById(UUID id, Orders order) {
        String sql = "update Orders " +
                "set order_id = '" + order.getOrderId() + "'" +
                ",order_date = '" + order.getOrderDate() + "'" +
                ",customers_customer_id = '" + order.getCustomerID() + "'" +
                "where order_id = '" + id + "';";
        jdbcTemplate.update(sql);
    }
}



