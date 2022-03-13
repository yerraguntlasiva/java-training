package com.example.demo;

import java.io.Serializable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.example.demo.beans.Employee;
import com.example.demo.config.Config;
import com.example.demo.dao.EmployeeDao;

@SpringBootApplication
public class Demo9HibernateTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext ct=new AnnotationConfigApplicationContext(Config.class);
		EmployeeDao dao=ct.getBean(EmployeeDao.class);
		Employee e1=new Employee(101,"srk","srk@gmail.com");
		Serializable i=dao.save(e1);
		System.out.println("save : "+i);
		Employee e2=dao.getEmployee(101);
		System.out.println("e2 : "+e2);
	}
	
	

}
