package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerDao {

	Customer insertCustomer(Customer customer);

	List<Customer> selectAllCustomers();

	Optional<Customer> selectCustomerById(UUID id);

	void deleteCustomerById(UUID id);

	Customer updateCustomerById(UUID id, Customer customer);
}
