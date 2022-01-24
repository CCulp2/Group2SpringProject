package com.example.demo.dao;

import com.example.demo.model.Customer;

import java.util.UUID;
import java.util.List;

public interface CustomerDao {
    int insertCustomer(UUID id, Customer customer);

    default int insertCustomer(Customer customer){
        UUID id = UUID.randomUUID();
        return insertCustomer(id, customer);
    }


    List<Customer> selectAllCustomers();
}
