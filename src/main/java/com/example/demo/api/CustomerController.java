package com.example.demo.api;


import com.example.demo.model.UsernamePasswordMap;
import com.example.demo.service.CustomerService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.example.demo.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RequestMapping("api/v1/customer")
@RestController
@RequiredArgsConstructor
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


	@PostMapping("/login")
	@CrossOrigin
	public ResponseEntity<?> loginCustomer(@RequestBody UsernamePasswordMap login) {
		Optional<Customer> customer = customerService.getCustomerByUsername(login.getUsername());
		if (!customer.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			if (!customer.get().getPassword().equals(login.getPassword())) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>(customer.get(), HttpStatus.OK);
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping(path = "{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") Long id) { return customerService.getCustomerById(id); }

	@DeleteMapping(path = "{id}")
	public void deleteCustomerById(@PathVariable("id") Long id) { customerService.deleteCustomer(id); }

	@PutMapping(path = "{id}")
	@CrossOrigin
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customerToUpdate) {
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

	@GetMapping("/customer/refresh")
	@CrossOrigin
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
		String authorizationHeader = request.getHeader(AUTHORIZATION);
	}
}

@Data
class RoleToUserForm{
	private String username;
	private String roleName;
}
