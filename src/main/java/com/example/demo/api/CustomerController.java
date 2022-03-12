package com.example.demo.api;

import com.example.demo.service.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

	
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	@CrossOrigin
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping(path = "{id}")
	public List<Customer> getCustomerById(@PathVariable("id") UUID id) {
		return customerService.getCustomerById(id);
//			.orElse(null);
	}

	@DeleteMapping(path = "{id}")
	public int deleteCustomerById(@PathVariable("id") UUID id) {
		return customerService.deleteCustomer(id);
	}

	@PutMapping(path = "{id}")
	@CrossOrigin
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") UUID id, @RequestBody Customer customerToUpdate) {
		customerService.updateCustomer(id, customerToUpdate);
		return new ResponseEntity<Customer>(customerToUpdate, HttpStatus.OK);
	}
}
