package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeCustomerDataAccessService implements CustomerDao{

    private static List<Customer> DB = new ArrayList<>();

    @Override
    public int insertCustomer(UUID id, Customer customer){
        DB.add(new Customer(id, customer.getName()));
        return 1;
    }
}
