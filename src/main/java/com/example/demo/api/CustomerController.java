package com.example.demo.api;


import com.example.demo.model.UsernamePasswordMap;
import com.example.demo.service.CustomerService;
import java.util.List;
import java.util.Optional;
import com.example.demo.model.Customer;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/customer")
@RestController
@CrossOrigin("*")
public class CustomerController {

	
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	@CrossOrigin
	public ResponseEntity<Customer> addCustomer( @RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}


	@PostMapping("/login")
	@CrossOrigin
	public ResponseEntity<?> loginCustomer(@RequestBody @NotNull UsernamePasswordMap login) {
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
	public Optional<Customer> getCustomerById(@PathVariable("id") int id) { return customerService.getCustomerById(id); }

	@DeleteMapping(path = "{id}")
	public void deleteCustomerById(@PathVariable("id") int id) { customerService.deleteCustomer(id); }

	@PutMapping(path = "{id}")
	@CrossOrigin
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customerToUpdate) {
		customerService.updateCustomer(id, customerToUpdate);
		return new ResponseEntity<Customer>(customerToUpdate, HttpStatus.OK);
	}
}
