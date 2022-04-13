package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String city;
	private String state;
	@ManyToMany(fetch = EAGER)
	private Collection<UserRole> roles = new ArrayList<>();



//	public void setId(Long id) {this.id = id;}
//
//	public void setFirstName(String firstName) { this.firstName = firstName; }
//
//	public void setLastName(String lastName) { this.lastName = lastName; }
//
//	public void setUsername(String username) { this.username = username; }
//
//	public void setPassword(String password) { this.password = password; }
//
//	public void setAddress(String address) { this.address = address; }
//
//	public void setCity(String city) { this.city = city; }
//
//	public void setState(String state) { this.state = state; }
//
//	public Long getId() { return id; }
//
//	public String getFirstName() { return firstName; }
//
//	public String getLastName() {return lastName; }
//
//	public String getUsername() {return username; }
//
//	public String getPassword() {return password; }
//
//	public String getAddress() {return address; }
//
//	public String getCity() {return city; }
//
//	public String getState() {return state; }
//
//	public Collection<UserRole> getRole() {
//		return role;
//	}
//
//	public void setRole(Collection<UserRole> role) {
//		this.role = role;
//	}

//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return role;
//	}
}
