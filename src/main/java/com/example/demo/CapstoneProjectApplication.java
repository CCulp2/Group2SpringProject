package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class CapstoneProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CustomerService service) {
		return args -> {
			if (service.getCustomerByUsername("ADMIN").isEmpty()) {
				Customer admin = new Customer();
				admin.setUsername("ADMIN");
				admin.setPassword("PASSWORD");
				service.addCustomer(admin);
			}
		};
	}

}
