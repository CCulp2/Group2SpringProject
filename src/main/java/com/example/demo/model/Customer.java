package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="customers")
@NoArgsConstructor
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String city;
	private String state;
}
