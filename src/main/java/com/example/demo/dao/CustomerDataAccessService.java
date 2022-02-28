package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
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
        String sql = "insert into customers (customer_ID, first_name, last_name, username, password, birth_date, phone, address, city, state) values" +
                "('" + id +"'" +
                ", '" + customer.getName() +"'" +
                ", '" + customer.getLastName() + "'" +
                ", '" + customer.getUsername() + "'" +
                ", '" + customer.getPassword() + "'" +
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

        String sql = "select customer_id, first_name, last_name, username, password, birth_date, phone, address, city, state from customers;";
        List<Customer> customers = jdbcTemplate.query(sql, (resultSet, i) -> {
            String id = resultSet.getString("customer_id");
            UUID customerId = UUID.fromString(id);
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String birthDate = resultSet.getString("birth_date");
            String phone = resultSet.getString("phone");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");
            return new  Customer(customerId, firstName, lastName, username, password, birthDate, phone, address, city, state);
        });
        return customers;

    }

    @Override
    public List<Customer> selectCustomerById(UUID id) {

        String sql = "select customer_id, first_name, last_name, username, password, birth_date, phone, address, city, state from customers where customer_id = '" + id + "';";
        List<Customer> customer = jdbcTemplate.query(sql, (resultSet, i) -> {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String birthDate = resultSet.getString("birth_date");
            String phone = resultSet.getString("phone");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");
            return new  Customer(id, firstName, lastName, username, password, birthDate, phone, address, city, state);
        });
        return customer;
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
    public int updateCustomerById(UUID id, Customer customer) {
//        String sql = "update customers " +
//                "set" + //gotta figure out how to allow the update of any field without creating a method for each one.
//                "where customer_id='" + id + "';";
//        jdbcTemplate.update(sql);
        return 0;
    }
}
