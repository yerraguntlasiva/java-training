package com.org.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Employee")
public class Employee {
	
	@Id
	private int id;
	private String name;
	private String email;
	private String password;
	private float salary;
	private String permission;
	
	public Employee() {}

	public Employee(int id, String name, String email, String password, String permission) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.permission = permission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", permission="
				+ permission + "]";
	}
	
	
	

}
