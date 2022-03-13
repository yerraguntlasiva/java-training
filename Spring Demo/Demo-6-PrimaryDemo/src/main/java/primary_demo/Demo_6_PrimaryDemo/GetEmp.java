package primary_demo.Demo_6_PrimaryDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import primary_demo.Demo_6_PrimaryDemo.beans.Emp;

@Component
public class GetEmp {
	
	@Bean(name="emp2")
	@Primary()
	@Lazy
	public Emp getEmp2() {
		System.out.println("getEmp2() is called");
		return new Emp("Rahul");
	}
}
