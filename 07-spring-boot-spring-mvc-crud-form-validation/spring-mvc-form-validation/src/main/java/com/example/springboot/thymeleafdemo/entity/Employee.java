package com.example.springboot.thymeleafdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=2, message="is required")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message="is required")
	@Size(min=2, message="is required")
	@Column(name="email")
	private String email;

	@Min(value=0, message="must be greater than or equal to 0!")
	@Max(value=10, message="must be greater than or equal to 10!")
	@Column(name="priority")
	private int priority;
	
	public Employee() {}
	
	public Employee(int id, String firstName, String lastName, String email, int priority) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.priority = priority;
	}

	public Employee(String firstName, String lastName, String email, int priority) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.priority = priority;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", priority=" + priority + "]";
	}
		
}











