package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("MYSQL")
public class CustomerDataAccessService implements CustomerDao{

    private CustomerRepository customerRepo;

    @Autowired
    public CustomerDataAccessService(CustomerRepository customerRepo) { this.customerRepo = customerRepo; }

    @Override
    public Customer insertCustomer(Customer customer) { return customerRepo.save(customer); }

    @Override
    public List<Customer> selectAllCustomers() { return customerRepo.findAll(); }

    @Override
    public Optional<Customer> selectCustomerById(UUID id) {
        Optional<Customer> customerToReturn = customerRepo.findById(id);
        return customerToReturn;
    }

    @Override
    public void deleteCustomerById(UUID id) { customerRepo.deleteAllById(Collections.singleton(id)); }

    @Override
    public Customer updateCustomerById(UUID id, Customer customer) {
        Customer customerToUpdate = customerRepo.getById(id);
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setUsername(customer.getUsername());
        customerToUpdate.setAddress(customer.getAddress());
        customerToUpdate.setCity(customer.getCity());
        customerToUpdate.setState(customer.getState());
        customerToUpdate.setPassword(customer.getPassword());
        customerRepo.save(customerToUpdate);

        return customerToUpdate;
    }
}
