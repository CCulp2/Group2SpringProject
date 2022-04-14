package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.model.UserRole;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Repository("MYSQL")
@RequiredArgsConstructor
@Service
@Transactional
public class CustomerDataAccessService implements CustomerDao {

    private final CustomerRepository customerRepo;
    private final UserRoleRepository roleRepo;

//    @Autowired
//    public CustomerDataAccessService(CustomerRepository customerRepo, UserRoleRepository roleRepo) { this.customerRepo = customerRepo; this.roleRepo = roleRepo; }

    @Override
    public Customer insertCustomer(Customer customer) {
        UserRole role = roleRepo.findByName("CUSTOMER");
        customer.getRoles().add(role);
        return customerRepo.save(customer); }

    @Override
    public List<Customer> selectAllCustomers() { return customerRepo.findAll(); }

    @Override
    public Optional<Customer> selectCustomerById(Long id) {
        Optional<Customer> customerToReturn = customerRepo.findById(id);
        return customerToReturn;
    }

    public Optional<Customer> selectCustomerByUsername(String name) {
        Optional<Customer> customerToReturn = customerRepo.findCustomerByUsername(name);
        return customerToReturn;
    }

    @Override
    public void deleteCustomerById(Long id) { customerRepo.deleteAllById(Collections.singleton(id)); }

    @Override
    public Customer updateCustomerById(Long id, Customer customer) {
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
