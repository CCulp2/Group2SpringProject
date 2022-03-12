package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="customers")
public class Customer {

	@Id
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

//	public Customer(@JsonProperty("id") UUID id,
//				    @JsonProperty("firstName") String name,
//					@JsonProperty("lastName") String lastName,
//					@JsonProperty("username") String username,
//					@JsonProperty("password") String password,
//					@JsonProperty("birthDate") String birthDate,
//					@JsonProperty("phone") String phone,
//					@JsonProperty("address") String address,
//					@JsonProperty("city") String city,
//					@JsonProperty("state") String state) {
//		this.id = id;
//		this.firstName= name;
//		this.lastName = lastName;
//		this.username = username;
//		this.password = password;
//		this.address = address;
//		this.city = city;
//		this.state = state;
//	}

	public Customer() {

	}

	public void setId(UUID id) {this.id = id;}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return firstName;
	}

	public String getLastName() {return lastName; }

	public String getUsername() {return username; }

	public String getPassword() {return password; }

	public String getAddress() {return address; }

	public String getCity() {return city; }

	public String getState() {return state; }



	
}
