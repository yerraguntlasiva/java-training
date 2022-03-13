package com.org.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.beans.Employee;
import com.org.repository.EmployeeRepository;

@Component
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;
	
	@Autowired
	HttpServletRequest request;
	public String login(String email,String password) {
		Employee emp=repo.findByEmailAndPassword(email,password);
		System.out.println("emp in service : "+emp);
		if(emp!=null) {
			request.getSession().setAttribute("emp", emp);
			List<Employee> list=repo.findAll();
			request.getSession().setAttribute("empList", list);
			return "Home";
		}
		else {
			request.getSession().setAttribute("error", "email or password is not correct");
			return "index";
		}
		
	}
	public String register(Employee employee) {
		Employee emp=repo.save(employee);
		System.out.println("service : emp  :registeR: "+emp);
		if(emp!=null) {
			request.getSession().setAttribute("message", "Employee Register Successfully...");
		}
		else {
			request.getSession().setAttribute("error", "Error While Registering Employee");
		}
		return "index";
	}
	public String update(Employee employee) {
		// TODO Auto-generated method stub
		Employee emp=repo.save(employee);
		if(emp!=null) {
			List<Employee> list=repo.findAll();
			request.getSession().setAttribute("empList", list);
			request.getSession().setAttribute("message", "Employee Updated Successfully...");
		}
		else {
			request.getSession().setAttribute("error", "Error While Updating Employee");
		}
		return "Home";
	}
	
	public String delete(int id) {
		repo.deleteById(id);
		request.getSession().setAttribute("message", "Employee Deleted Successfully...");
		List<Employee> list=repo.findAll();
		request.getSession().setAttribute("empList", list);
		return "Home";
	}
	public String logoug() {
		request.getSession().invalidate();
		return "index";
	}

}
