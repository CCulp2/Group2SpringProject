package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="customers")
@NoArgsConstructor
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String city;
	private String state;
}
