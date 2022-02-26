package com.example.demo.api;

import com.example.demo.service.CustomerService;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

	
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping(path = "{id}")
	public List<Customer> getCustomerById(@PathVariable("id") String id) {
		return customerService.getCustomerById(id);
//			.orElse(null);
	}

	@DeleteMapping(path = "{id}")
	public int deleteCustomerById(@PathVariable("id") String id) {
		return customerService.deleteCustomer(id);
	}

	@PutMapping(path = "{id}")
	public void updateCustomer(@PathVariable("id") String id, @RequestBody Customer customerToUpdate) {
		customerService.updateCustomer(id, customerToUpdate);
	}
}
