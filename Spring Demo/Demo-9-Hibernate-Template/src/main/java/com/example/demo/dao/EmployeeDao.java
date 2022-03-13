package com.example.demo.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.beans.Employee;

public class EmployeeDao {
	@Autowired
	private HibernateTemplate jdbcTemplate;

	public EmployeeDao() {
		System.out.println("hibernate tmepl  : " + jdbcTemplate);

	}

	@Transactional(readOnly = false)
	public Serializable save(Employee employee) {
		System.out.println("save *********** ");
		return this.jdbcTemplate.save(employee);
	}

	public void update(Employee employee) {
		this.jdbcTemplate.update(employee);
	}

	public void delete(Employee employee) {
		this.jdbcTemplate.delete(employee);
	}

	public Employee getEmployee(Integer id) {
		return this.jdbcTemplate.get(Employee.class, id);
	}
}
