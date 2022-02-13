package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MYSQL")
public class CustomerDataAccessService implements CustomerDao{

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CustomerDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCustomer(UUID id, Customer customer) {
        String sql = "insert into customers (Customer_ID, first_name, last_name, birth_date, phone, address, city, state) values(1234, 'test', 'test', '2020-1-1', 4444444444, '9999 test creek','orlando','fl');";
        jdbcTemplate.update(sql);



        return 0;
    }

    @Override
    public int insertCustomer(Customer customer) {
        return CustomerDao.super.insertCustomer(customer);
    }

    @Override
    public List<Customer> selectAllCustomers() {

        String datbase = "idk";
        return List.of(new Customer(UUID.randomUUID(), datbase ));

    }

    @Override
    public Optional<Customer> selectCustomerById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteCustomerById(UUID id) {
        return 0;
    }

    @Override
    public int updateCustomerById(UUID id, Customer customer) {
        return 0;
    }
}
