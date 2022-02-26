package com.example.demo.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
	
	private UUID id;
	private String name;
	private String lastName;
	private String birthDate;
	private String phone;
	private String address;
	private String city;
	private String state;

	public Customer(@JsonProperty("id") UUID id,
				    @JsonProperty("name") String name,
					@JsonProperty("lastName") String lastName,
					@JsonProperty("birthDate") String birthDate,
					@JsonProperty("phone") String phone,
					@JsonProperty("address") String address,
					@JsonProperty("city") String city,
					@JsonProperty("state") String state) {
		this.id = id;
		this.name= name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {return lastName; }

	public String getBirthDate() {return birthDate; }

	public String getPhone() {return phone; }

	public String getAddress() {return address; }

	public String getCity() {return city; }

	public String getState() {return state; }



	
}
