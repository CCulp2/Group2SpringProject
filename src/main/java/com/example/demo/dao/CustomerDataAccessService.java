package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.model.UserRole;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;


@Repository("MYSQL")
@Service
public class CustomerDataAccessService implements CustomerDao {

    private final CustomerRepository customerRepo;
    private final UserRoleRepository roleRepo;

    @Autowired
    public CustomerDataAccessService(CustomerRepository customerRepo, UserRoleRepository roleRepo) { this.customerRepo = customerRepo; this.roleRepo = roleRepo; }

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

    @Override
    public Customer getCustomerByUsername(String username) {
        Customer customer = customerRepo.findByUsername(username);
        return customer;
    }

    @Override
    public UserRole saveRole(UserRole role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToCustomer(String username, String roleName) {
        Customer customer = customerRepo.findByUsername(username);
        UserRole role = roleRepo.findByName(roleName);
        customer.getRole().add(role);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Customer customer = customerRepo.findByUsername(username);
//        if(customer == null) {
//            throw new UsernameNotFoundException("User not found in database");
//        } else {
//            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//            customer.getRole().forEach(role ->
//                    authorities.add(new SimpleGrantedAuthority(role.getName())));
//            return new org.springframework.security.core.userdetails.User(customer.getUsername(), customer.getPassword(), authorities);
//        }
//    }
}
