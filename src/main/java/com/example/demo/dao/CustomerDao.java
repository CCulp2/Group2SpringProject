package com.example.demo.dao;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerDao {

	Customer insertCustomer(Customer customer);

	List<Customer> selectAllCustomers();

	Optional<Customer> selectCustomerById(int id);

	Optional<Customer> selectCustomerByUsername(String username);

	void deleteCustomerById(int id);

	Customer updateCustomerById(int id, Customer customer);
}
