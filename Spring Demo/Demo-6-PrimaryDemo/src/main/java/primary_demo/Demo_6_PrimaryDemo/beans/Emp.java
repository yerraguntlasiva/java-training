package primary_demo.Demo_6_PrimaryDemo.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Emp {
	private String name;

	public Emp() {}
	public Emp(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + "]";
	}
	
	@Bean(name="emp2")
	@Primary()
	@Lazy
	public Emp getEmp2() {
		System.out.println("getEmp2() is called");
		return new Emp("Rahul");
	}
}
