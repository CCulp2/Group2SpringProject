package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository("MYSQL")
public class CustomerDataAccessService implements CustomerDao{

    private final JdbcTemplate jdbcTemplate;
    private CustomerRepository customerRepo;

    @Autowired
    public CustomerDataAccessService(JdbcTemplate jdbcTemplate, CustomerRepository customerRepo) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRepo = customerRepo;
    }


    @Override
    public ResponseEntity<Customer> insertCustomer(Customer customer) {
        customer.setId(UUID.randomUUID());
        customerRepo.save(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public ResponseEntity<Customer> selectCustomerById(UUID id) {
        Customer customerToReturn = customerRepo.findAllById();
        return ResponseEntity<Customer>(customerToReturn, HttpStatus.OK);
    }
//    Eventually, get the Optional part working.
//    @Override
//    public Optional<Customer> selectCustomerById(String id) {
//        String sql = "select customer_id, first_name, last_name, username, password, birth_date, phone, address, city, state from customers where customer_id =?";
//        Customer customer = jdbcTemplate.queryForObject(sql,
//                new Object[]{id},
//                (resultSet, i) -> {
//                    String firstName = resultSet.getString("first_name");
//                    String lastName = resultSet.getString("last_name");
//                    String username = resultSet.getString("username");
//                    String password = resultSet.getString("password")
//                    String birthDate = resultSet.getString("birth_date");
//                    String phone = resultSet.getString("phone");
//                    String address = resultSet.getString("address");
//                    String city = resultSet.getString("city");
//                    String state = resultSet.getString("state");
//                    return new  Customer(id, firstName, lastName, birthDate, phone, address, city, state);
//        });
//        return Optional.ofNullable(customer);
//    }

    @Override
    public int deleteCustomerById(UUID id) {
        String sql = "delete from customers where customer_id = '" + id + "';";
        jdbcTemplate.update(sql);
        return 0;
    }

    @Override
    public void updateCustomerById(UUID id, Customer customer) {
        String sql = "update customers " +
                "set first_name = '" + customer.getName() + "'" +
                ",last_name = '" + customer.getLastName() + "'" +
                ",username = '" + customer.getUsername() + "'" +
                ",password = '" + customer.getPassword() + "'" +
                ",address = '" + customer.getAddress() + "'" +
                ",city = '" + customer.getCity() + "'" +
                ",state = '" + customer.getState() + "'" +
                "where customer_id = '" + id + "';";

        jdbcTemplate.update(sql);
    }
}
