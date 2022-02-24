package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
import org.springframework.format.annotation.DateTimeFormat;
=======
>>>>>>> Stashed changes
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("MYSQL")
public class CustomerDataAccessService implements CustomerDao{

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CustomerDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCustomer(UUID id, Customer customer) {
        //String idGenerator = UUID.randomUUID().toString();
        String sql = "insert into customers (Customer_ID, first_name, last_name, birth_date, phone, address, city, state) values" +
                "('" + id +"'" +
                ", '" + customer.getName() +"'" +
                ", '" + customer.getLastName() + "'" +
                ", '" + customer.getBirthDate() + "'" +
                ", " + customer.getPhone() + "" +
                ", '" + customer.getAddress() + "'" +
                ",'" + customer.getCity() + "'" +
                ",'" + customer.getState() + "');";
        jdbcTemplate.update(sql);
        return 0;
    }

    @Override
    public int insertCustomer(Customer customer) {
        return CustomerDao.super.insertCustomer(customer);
    }

    @Override
    public List<Customer> selectAllCustomers() {

        String sql = "select customer_id, first_name, last_name, birth_date, phone, address, city, state from customers;";
        List<Customer> customers = jdbcTemplate.query(sql, (resultSet, i) -> {
            String id = resultSet.getString("customer_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String birthDate = resultSet.getString("birth_date");
            String phone = resultSet.getString("phone");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");
            return new  Customer(id, firstName, lastName, birthDate, phone, address, city, state);
        });
        return customers;

    }

    @Override
    public Optional<Customer> selectCustomerById(UUID id) {
        return Optional.empty();
    }

    @Override
<<<<<<< Updated upstream
    public int deleteCustomerById(UUID id) {
        return 0;
=======
    public List<Customer> deleteCustomerById(String id) {
        String sql = "delete customer_id, first_name, last_name, birth_date, phone, address, city, state from customers where customer_id = '" + id + "';";
        List<Customer> customerToDelete = selectCustomerById(id);
//        List<Customer> customerToDelete = jdbcTemplate.query(sql, (resultSet, i) -> {
//            String firstName = resultSet.getString("first_name");
//            String lastName = resultSet.getString("last_name");
//            String birthDate = resultSet.getString("birth_date");
//            String phone = resultSet.getString("phone");
//            String address = resultSet.getString("address");
//            String city = resultSet.getString("city");
//            String state = resultSet.getString("state");
//            return new Customer(id, firstName, lastName, birthDate, phone, address, city, state);
//        });
        return jdbcTemplate.update(sql, customerToDelete);
>>>>>>> Stashed changes
    }

    @Override
    public int updateCustomerById(UUID id, Customer customer) {
        return 0;
    }
}
