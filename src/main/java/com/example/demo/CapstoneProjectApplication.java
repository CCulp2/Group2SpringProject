package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.model.UserRole;
import com.example.demo.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CapstoneProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneProjectApplication.class, args);



	}

	@Bean
	CommandLineRunner run(CustomerService service) {
		return args -> {
			try {
				service.loadUserByUsername("ADMIN");
			} catch (UsernameNotFoundException e) {
				service.saveRole(new UserRole(null, "ADMIN"));
				service.saveRole(new UserRole(null, "CUSTOMER"));
				Customer admin = new Customer("ADMIN", "PASSWORD");
				service.addCustomer(admin);
				service.addRoleToCustomer("ADMIN", "ADMIN");
				service.addRoleToCustomer("ADMIN", "CUSTOMER");
			}
		};
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
