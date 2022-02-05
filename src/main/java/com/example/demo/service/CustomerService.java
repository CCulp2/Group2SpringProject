package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	private final CustomerDao customerDao;

	@Autowired
	public CustomerService(@Qualifier("fakeDao") CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public int addCustomer(Customer customer) {
		return customerDao.insertCustomer(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerDao.selectAllCustomers();
	}

	public Optional<Customer> getCustomerById(UUID id) {
		return customerDao.selectCustomerById(id);
	}

	public int deleteCustomer(UUID id) {
		return customerDao.deleteCustomerById(id);
	}

	public int updateCustomer(UUID id, Customer newCustomer) {
		return customerDao.updateCustomerById(id, newCustomer);
	}
}
