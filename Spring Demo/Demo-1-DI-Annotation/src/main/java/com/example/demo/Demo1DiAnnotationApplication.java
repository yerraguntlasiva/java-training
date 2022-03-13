package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.beans.Emp;

@SpringBootApplication
public class Demo1DiAnnotationApplication {
	private static final Logger logger = LoggerFactory.getLogger(Demo1DiAnnotationApplication.class);
	public static void main(String[] args) {
		
		ApplicationContext ctx =SpringApplication.run(Demo1DiAnnotationApplication.class, args);
		Emp e1 = ctx.getBean( Emp.class);
		e1.showAdressEmp();
		logger.error("error");
	}

}
