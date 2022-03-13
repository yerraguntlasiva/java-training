import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Student;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");

		      Student student = (Student) context.getBean("student");

		      student.getName();
		      student.getAge(); 

	}

}
