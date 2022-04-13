package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.model.UserRole;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerDao {

	Customer insertCustomer(Customer customer);

	List<Customer> selectAllCustomers();

	Optional<Customer> selectCustomerById(Long id);

	void deleteCustomerById(Long id);

	Customer updateCustomerById(Long id, Customer customer);

	Customer getCustomerByUsername(String name);

	UserRole saveRole(UserRole role);

	void addRoleToCustomer(String username, String roleName);
}
