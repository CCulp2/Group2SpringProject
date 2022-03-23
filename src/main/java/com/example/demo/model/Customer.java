package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name="uuid2", strategy = "uuid2")
	@Column(name="customer_id")
	@Type(type="uuid-char")
	private UUID id;
	@Column(name="first_Name", nullable = false)
	private String firstName;
	@Column(name="last_name", nullable = false)
	private String lastName;
	@Column(name="username", nullable = false)
	private String username;
	@Column(name="password", nullable = false)
	private String password;
	@Column(name="address", nullable = false)
	private String address;
	@Column(name="city", nullable = false)
	private String city;
	@Column(name="state", nullable = false)
	private String state;


	public Customer() { }



	public void setId(UUID id) {this.id = id;}

	public void setFirstName(String firstName) { this.firstName = firstName; }

	public void setLastName(String lastName) { this.lastName = lastName; }

	public void setUsername(String username) { this.username = username; }

	public void setPassword(String password) { this.password = password; }

	public void setAddress(String address) { this.address = address; }

	public void setCity(String city) { this.city = city; }

	public void setState(String state) { this.state = state; }

	public UUID getId() { return id; }

	public String getFirstName() { return firstName; }

	public String getLastName() {return lastName; }

	public String getUsername() {return username; }

	public String getPassword() {return password; }

	public String getAddress() {return address; }

	public String getCity() {return city; }

	public String getState() {return state; }

}
