package com.acrmapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "first_name", length = 45, nullable = false)
	private String firstName;
	@Column(name = "last_name", length = 45, nullable = false)
	private String lastName;
	@Column(name = "email", length = 128, nullable = false, unique = true)
	private String email;
	private String leadsource;
	@Column(name = "mobile", length = 10, nullable = false, unique = true)
	private String mobile;

	public Contact() {

	}

	public Contact(String firstName, String lastName, String email, String leadsource, String mobile) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.leadsource = leadsource;
		this.mobile = mobile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLeadsource() {
		return leadsource;
	}

	public void setLeadsource(String leadsource) {
		this.leadsource = leadsource;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}