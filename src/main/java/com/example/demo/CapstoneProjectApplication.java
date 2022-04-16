package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CapstoneProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CustomerService customerService, ProductService productService) {
		Resource productsJSON = new ClassPathResource("productsList.JSON");
		return args -> {
			if (customerService.getCustomerByUsername("ADMIN").isEmpty()) {
				Customer admin = new Customer();
				admin.setUsername("ADMIN");
				admin.setPassword("PASSWORD");
				customerService.addCustomer(admin);
				ObjectMapper map = new ObjectMapper();
				TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>(){};
				InputStream inputStream = productsJSON.getInputStream();
				try {
					List<Product> products = map.readValue(inputStream, typeReference);
					productService.addProducts(products);
				} catch (IOException e) {
					System.out.println("Failed to log products because");
					System.out.println(e);
				}
			}
		};
	}
}
