package com.example.demo.dao;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerDao {

	Customer insertCustomer(Customer customer);

	List<Customer> selectAllCustomers();

	Optional<Customer> selectCustomerById(Long id);

	Optional<Customer> selectCustomerByUsername(String username);

	void deleteCustomerById(Long id);

	Customer updateCustomerById(Long id, Customer customer);
}
