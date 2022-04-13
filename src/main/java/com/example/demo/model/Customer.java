package com.example.demo.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String city;
	private String state;
	@ManyToMany(fetch = EAGER)
	private Collection<UserRole> role = new ArrayList<>();


	public Customer() { }

	public Customer(String username, String password) {
		this.username = username;
		this.password = password;
	}



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

	public Collection<UserRole> getRole() {
		return role;
	}

	public void setRole(Collection<UserRole> role) {
		this.role = role;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
}
