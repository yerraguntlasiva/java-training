package com.org;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.beans.Emp;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		float salary=Float.parseFloat(request.getParameter("salary"));
		boolean current_user=Boolean.parseBoolean(request.getParameter("current_user"));
		request.getSession().setAttribute("email", email);
		String sql="update emp2 set name=?, email=?, password=?, salary=? where id=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");PreparedStatement ps=con.prepareStatement(sql)) {
			ps.setInt(5, id);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setFloat(4, salary);
			int update=ps.executeUpdate();
			if(update>0) {
				if(current_user) {
					Emp oldEmp=(Emp) request.getSession().getAttribute("emp");
					Emp e=new Emp(id,name,email,password,salary,oldEmp.getPermission());
					request.getSession().setAttribute("emp",e);
				}
				Login.getAllEmp(request, con);
				request.getSession().setAttribute("message", "user Updated SuccessFull");	
				RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");
				rd.forward(request, response);
				return;
			}
			else {
				request.getSession().setAttribute("error", "Something Wrong in Register");
				RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");
				rd.forward(request, response);
				return;
			}
			
		}
		catch(Exception e) {
			System.out.println("execption  : "+e);
			request.getSession().setAttribute("error", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
