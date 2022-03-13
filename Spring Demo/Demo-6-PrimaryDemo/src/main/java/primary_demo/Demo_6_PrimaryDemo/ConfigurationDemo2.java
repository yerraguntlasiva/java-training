package primary_demo.Demo_6_PrimaryDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import primary_demo.Demo_6_PrimaryDemo.beans.Emp;

@Configuration
public class ConfigurationDemo2 {
	
	public ConfigurationDemo2() {
		System.out.println("ConfigurationDemo2 (0");
	}
	
	@Bean(name="emp1")
	@Lazy
	public Emp getEmp1() {
		System.out.println("getEmp1() is called");
		return new Emp("sharukh");
	}
	

	

	
	

}
