package com.example.demo.dao;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerDao {
	
	int insertCustomer(UUID id, Customer customer);

	default int insertCustomer(Customer customer) {
		UUID id = UUID.randomUUID();
		return insertCustomer(id, customer);
	}

	List<Customer> selectAllCustomers();

	Optional<Customer> selectCustomerById(UUID id);

	List<Customer> deleteCustomerById(String id);

	int updateCustomerById(UUID id, Customer customer);
}
