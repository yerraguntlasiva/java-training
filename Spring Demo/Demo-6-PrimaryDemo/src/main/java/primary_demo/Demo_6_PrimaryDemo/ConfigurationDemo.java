package primary_demo.Demo_6_PrimaryDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import primary_demo.Demo_6_PrimaryDemo.beans.Emp;

@Configuration
public class ConfigurationDemo {
	
	@Bean
	@Primary
	//@Scope(value = "prototype")
	public static Emp getEmp2() {
		//System.out.println("getEmp2() is called");
		return new Emp("Rahul");
	}
	
	@Bean(name="emp2")
	public static Emp getEmp23() {
		//System.out.println("getEmp2() is called");
		return new Emp("Sharukh");
	}
	

	//public ConfigurationDemo() {}
	

}
