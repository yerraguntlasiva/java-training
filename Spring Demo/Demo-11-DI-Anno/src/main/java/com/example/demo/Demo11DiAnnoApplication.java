package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.beans.Adress;
import com.example.demo.beans.Emp;
import com.example.demo.config.EmpConfig;

@SpringBootApplication
@ComponentScan("com.example.demo")
public class Demo11DiAnnoApplication {

	
	public static void main(String[] args) {
		ApplicationContext ct=new AnnotationConfigApplicationContext(EmpConfig.class);
		Emp e=ct.getBean(Emp.class);
		System.out.println("emp  :"+e);
		e.showEmp();
	}

}
