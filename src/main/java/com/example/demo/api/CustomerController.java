package com.example.demo.api;

import com.example.demo.model.UserRole;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.CustomerService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.example.demo.model.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

	
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService, UserRoleRepository roleService) {
		this.customerService = customerService;
	}

	@PostMapping
	@CrossOrigin
	public ResponseEntity<Customer> addCustomer( @RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping(path = "{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") UUID id) {
		return customerService.getCustomerById(id);
	}

	@DeleteMapping(path = "{id}")
	public void deleteCustomerById(@PathVariable("id") UUID id) {
		customerService.deleteCustomer(id);
	}

	@PutMapping(path = "{id}")
	@CrossOrigin
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") UUID id, @RequestBody Customer customerToUpdate) {
		customerService.updateCustomer(id, customerToUpdate);
		return new ResponseEntity<Customer>(customerToUpdate, HttpStatus.OK);
	}

	@PostMapping(path = "/role/save")
	@CrossOrigin
	public ResponseEntity<UserRole> saveRole(@RequestBody UserRole role) {
		return new ResponseEntity<UserRole>(customerService.saveRole(role), HttpStatus.OK);
	}

	@PostMapping(path = "/role/addToCustomer")
	@CrossOrigin
	public ResponseEntity<?> addRoleToCustomer(@RequestBody RoleToUserForm form) {
		customerService.addRoleToCustomer(form.getUsername(), form.getRoleName());
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

@Data
class RoleToUserForm{
	private String username;
	private String roleName;
}
