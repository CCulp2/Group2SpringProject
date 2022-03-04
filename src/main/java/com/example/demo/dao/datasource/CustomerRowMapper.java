package com.example.demo.dao.datasource;

import com.example.demo.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        return  new  Customer(
                resultSet.getObject("customer_id", UUID.class),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("birth_date"),
                resultSet.getString("phone"),
                resultSet.getString("address"),
                resultSet.getString("city"),
                resultSet.getString("state")
        );
    }
}
