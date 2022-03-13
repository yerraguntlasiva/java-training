package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.beans.Adress;
import com.example.demo.beans.Emp;

@Configuration
public class EmpConfig {
	
	@Autowired
	Emp emp;
	
	public EmpConfig() {
		System.out.println("EmpConfig :"+emp);
	}
	@Bean
	public Emp getEmp() {
		return new Emp();
	}
	
	@Bean
	public Adress getAdress() {
		return new Adress();
	}

}
