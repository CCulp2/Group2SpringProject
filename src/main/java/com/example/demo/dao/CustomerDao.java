package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface CustomerDao {

	default ResponseEntity<Customer> insertCustomer(Customer customer) {
		return insertCustomer(customer);
	}

	List<Customer> selectAllCustomers();

	ResponseEntity<Customer> selectCustomerById(UUID id);

	int deleteCustomerById(UUID id);

	void updateCustomerById(UUID id, Customer customer);
}
