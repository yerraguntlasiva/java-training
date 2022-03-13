package org.com;

import org.com.beans.Employee;
import org.com.dao.EmployeeDao;
import org.com.dao.EmployeeDaoNamedParameter;
import org.com.dao.EmployeeDaoPreparedStatement;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		/*
		EmployeeDao dao = (EmployeeDao) context.getBean("empDao");
		Employee e1 = new Employee(102, "srk2", "srk2@gmail.com");
		int i = dao.save(e1);
		dao.update(e1);
		dao.delete(e1);
		System.out.println("record saed : " + dao.getEmployee(102));
	
		*/
		
		/*
		EmployeeDaoPreparedStatement dao = (EmployeeDaoPreparedStatement) context.getBean("empDaoPre");
		Employee e1 = new Employee(102, "srk3", "srk234@gmail.com");
		boolean b = dao.save(new Employee(103, "srk37", "srk23478@gmail.com"));
		System.out.println("employeed save: " +b);
		dao.update(e1);
		dao.delete(e1);
		System.out.println("record saed : " + dao.getEmployee(102));
		System.out.println("record saed : " + dao.getEmpoyeesWithRowMap(null));
		 */
		
		EmployeeDaoNamedParameter dao = (EmployeeDaoNamedParameter) context.getBean("empDaoNamed");
		Employee e1 = new Employee(102, "srk3232", "234@gmail.com");
		//dao.save(new Employee(103, "srk37", "srk23478@gmail.com"));
		dao.update(e1);
		//dao.delete(e1);
		System.out.println("record saed : " + dao.getEmployee(103));
		 
	}

}
