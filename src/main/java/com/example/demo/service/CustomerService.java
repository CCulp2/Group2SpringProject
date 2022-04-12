package com.example.demo.service;

import java.util.*;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements UserDetailsService {
	
	private final CustomerDao customerDao;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public CustomerService(@Qualifier("MYSQL") CustomerDao customerDao, PasswordEncoder passwordEncoder) {
		this.customerDao = customerDao;
		this.passwordEncoder = passwordEncoder;
	}

	public Customer addCustomer(Customer customer) {
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		return customerDao.insertCustomer(customer);
	}


	public List<Customer> getAllCustomers() { return customerDao.selectAllCustomers(); }

	public Optional<Customer> getCustomerById(UUID id) { return customerDao.selectCustomerById(id); }

	public void deleteCustomer(UUID id) { customerDao.deleteCustomerById(id); }

	public Customer updateCustomer(UUID id, Customer newCustomer) { return customerDao.updateCustomerById(id, newCustomer); }

	public Customer updateCustomer(UUID id, Customer newCustomer) {
		return customerDao.updateCustomerById(id, newCustomer);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerDao.getCustomerByUsername(username);
		if(customer == null) {
			throw new UsernameNotFoundException("User not found in database");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		return new org.springframework.security.core.userdetails.User(customer.getUsername(), customer.getPassword(), authorities);
	}
}
