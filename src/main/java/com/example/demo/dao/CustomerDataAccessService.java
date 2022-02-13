package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MYSQL")
public class CustomerDataAccessService implements CustomerDao{
    @Override
    public int insertCustomer(UUID id, Customer customer) {
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
