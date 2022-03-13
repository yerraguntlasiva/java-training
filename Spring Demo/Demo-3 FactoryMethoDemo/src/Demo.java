
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.beans.A;
import com.javatpoint.A2;

public class Demo {

	public static void main(String[] args) {

		BeanFactory fb = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		/*
		 * PrintableFactory pf = (PrintableFactory) fb.getBean("pfactory");
		 * PrintableFactory pf2 = (PrintableFactory) fb.getBean("pfactory");
		 * PrintableFactory pf3 = (PrintableFactory) fb.getBean("pfactory");
		 * pf.getPrintable().print();
		 */
		 PrintableFactory pf = (PrintableFactory) fb.getBean("pfactory");
		 //A a4=(A) fb.getBean("a3");
		 //pf.getPrintable().print();
		  A2 a2=(A2) fb.getBean("a3"); 
		  a2.msg();
		 
	}

}
