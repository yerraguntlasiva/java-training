

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class EmpManagementSystem {
    public static void main(String[] arg) throws SQLException, ClassNotFoundException{
        showOptions();

    }
    
    public static int execute(Connection con,String sqlQuery) {
    	Statement st=null;
    	try {
    		st=con.createStatement();
        	
        	return st.executeUpdate(sqlQuery);
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	finally {
    		try {
    			if(con!=null)
    				con.close();
    			if(st!=null)
    				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		
    	}
		return 0;
    	
    }

    public static ResultSet executeQuery(Connection con,String sqlQuery) {
    	Statement st=null;
    	try {
    		st=con.createStatement();
        	return st.executeQuery(sqlQuery);
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	finally {
    		
    		
    	}
		return null;
    	
    }
    public static void showOptions() throws SQLException, ClassNotFoundException{
        Employee[] empArr=null;
        while (true){
            System.out.println("Please select option");
            System.out.println("1. Add Employees");
            System.out.println("2. Update Emploee");
            System.out.println("3. Delete Emploee");
            System.out.println("4. Displey Employee");
            System.out.println("5. Displey All  Employee");
            Scanner scanner=new Scanner(System.in);
            int option=scanner.nextInt();
            switch (option){
                case 1:
                    addEmp();
                    break;
                case  2:
                    updateEmp();
                    break;
                case 3:
                    deleteEmp();
                    break;
                case 4:
                    showEmp();
                    break;
                case 5:
                    showAllEmp();
                    break;
                default:
                    System.out.println("Entered InValid, please Enter Again");
                    break;
            }
        }
    }
    
    public static void addEmp() throws ClassNotFoundException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234")) {
    		Employee e=askEmployeeDetail();
        	String sql="insert into emp values("+e.getId()+",'"+e.getName()+"','"+e.getEmail()+"',"+e.getSalary()+")";
        	int i=execute(con, sql);
        	System.out.println(i+" records are added");
    	}
    	catch (Exception e) {
			System.out.println("add Emp"+e);
		}
    	
    }

    public static int askId(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please Enter Employee Id");
        int id= scanner.nextInt();
        return id;
    }

	/*
	 * public static Employee[] init(){ Scanner scanner=new Scanner(System.in);
	 * System.out.println("please enter Number of Employees"); int
	 * size=scanner.nextInt(); Employee[] empArr=new Employee[size]; for(int
	 * i=0;i<empArr.length;i++){
	 * System.out.println("asking emplyee detail count "+(i+1)); Employee
	 * e=askEmployeeDetail(); empArr[i]=e;
	 * 
	 * } return empArr; }
	 */
    public static Employee askEmployeeDetail(){
        Scanner scanner=new Scanner(System.in);
        Employee employee=new Employee();
        System.out.println("please Enter ID");
        employee.id= scanner.nextInt();
        System.out.println("please enter Name");
        employee.name=scanner.next();
        System.out.println("Please Enter Email");
        employee.email=scanner.next();
        System.out.println("please enter Salary");
        employee.salary=scanner.nextFloat();
        return  employee;
    }


	/*
	 * public static int findEmployee(Employee[] empArr){ int id=askId(); for(int
	 * i=0;i<empArr.length;i++){ if(empArr[i].getId()==id){ return i; } }
	 * 
	 * return -1; }
	 */

   
    public static void updateEmp() throws ClassNotFoundException{
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234")) {
    		Employee emp=askEmployeeDetail();
            String sql="update emp set name='"+emp.getName()+"' and email='"+emp.getEmail()+"' and salary="+emp.getSalary()+"";
            int numberOfRecordUpdated=execute(con, sql);
            System.out.println(numberOfRecordUpdated+" records are updated"); 
    	}
    	catch (Exception e) {
			System.out.println("update emp "+e);
		}
    	  
    }

    public static void deleteEmp() throws ClassNotFoundException{
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234")) {

    	int id=askId();
        String sql="delete emp where id="+id;
        int numberOfRecordUpdated=execute(con, sql);
        System.out.println(numberOfRecordUpdated+" records are deleted"); 
    	}
    	catch (Exception e) {
			System.out.println("delete Emp : "+e);
		}
    }

    public  static  void  showEmp() throws ClassNotFoundException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234")) {
    		int id=askId();
            String sql="select * from emp where id="+id;
            ResultSet rs=executeQuery(con, sql);
            while(rs.next()) {
            	Employee e1=new Employee();
            	e1.setId(rs.getInt("id"));
            	e1.setName(rs.getString("name"));
            	e1.setEmail(rs.getString("email"));
            	e1.setSalary(rs.getFloat("salary"));
            	System.out.println(e1);
            }
    	}
    	catch (Exception e) {
			System.out.println("No Record Faund for Entered Id "+e);
		}
    	
    	
    }
    public static void showAllEmp() throws ClassNotFoundException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234")) {
    		
    		String sql="select * from emp";
            ResultSet rs=executeQuery(con, sql);
            while(rs.next()) {
            	Employee e1=new Employee();
            	e1.setId(rs.getInt("id"));
            	e1.setName(rs.getString("name"));
            	e1.setEmail(rs.getString("email"));
            	e1.setSalary(rs.getFloat("salary"));
            	System.out.println(e1);
            }
    	}catch(Exception e) {
    		System.out.println("showEmp ( ) "+e);
    	}
    	
    	
    }
}
