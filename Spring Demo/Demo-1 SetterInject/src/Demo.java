

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.beans.Emp;

public class Demo {

	public static void main(String[] args) {
		BeanFactory fb=new XmlBeanFactory(new ClassPathResource("beans.xml"));
		Emp e1=(Emp) fb.getBean("emp");
		System.out.println(e1);

	}

}
