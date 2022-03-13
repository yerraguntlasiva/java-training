package primary_demo.Demo_6_PrimaryDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import primary_demo.Demo_6_PrimaryDemo.beans.Emp;

/**
 * Hello world!
 *
 */
@ComponentScan(basePackages= {"primary_demo.Demo_6_PrimaryDemo"})
@EnableAutoConfiguration
@Configuration
@SpringBootApplication
public class App 
{
	@Autowired(required = true)
	ConfigurationDemo configDemo;
	public App(ConfigurationDemo configDemo){
		this.configDemo=configDemo;
		System.out.println("app ini : "+configDemo);
	}
	
	//public App() {}
    public static void main( String[] args ) throws InterruptedException
    {
    	@SuppressWarnings("resource")
		ApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationDemo.class);
    	  Emp e = (Emp) appContext.getBean(Emp.class);//appContext.getBean(Emp.class);
    	 System.out.println("app :e "+e.getName());
    	 Emp e2 = (Emp) appContext.getBean("emp2",Emp.class);
    	 System.out.println("app :e2 "+e2.getName());
    }
    
    
    
}

