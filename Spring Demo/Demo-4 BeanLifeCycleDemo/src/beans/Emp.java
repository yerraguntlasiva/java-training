package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jws.soap.InitParam;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Emp implements InitializingBean,DisposableBean{
	
	int id;
	
	Emp(){
		System.out.println("Emp Cons");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public void init() {
		System.out.println("init method is called");
	}
	
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct method is called");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("preDestroy method is called");
	}
	public void destroy() {
		System.out.println("destroy metho is called");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet metho is called : id ="+this.id);
		
	}
	

}
