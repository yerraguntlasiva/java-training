package beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Demo {

	public static void main(String[] args) {
		/*
		 * ConfigurableApplicationContext cap= new
		 * ClassPathXmlApplicationContext("beans.xml"); Emp e1=(Emp) cap.getBean("emp");
		 * cap.close();
		 */

		AbstractApplicationContext ap=new ClassPathXmlApplicationContext("beans.xml");
		ap.registerShutdownHook();
		Emp e1=(Emp) ap.getBean("emp");
	}

}
