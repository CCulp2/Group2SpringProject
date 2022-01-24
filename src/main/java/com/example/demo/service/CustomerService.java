package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.dao.CustomerDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("fakeDao") CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    public int addCustomer(Customer customer){

        return customerDao.insertCustomer(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerDao.selectAllCustomers();
    }

}
