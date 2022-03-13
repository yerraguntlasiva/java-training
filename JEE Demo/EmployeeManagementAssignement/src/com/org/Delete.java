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

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		String sql="delete emp2 where id=?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");PreparedStatement ps=con.prepareStatement(sql)) {
			ps.setInt(1, id);
			int update=ps.executeUpdate();
			if(update>0) {
				Login.getAllEmp(request, con);
				request.getSession().setAttribute("message", "user Deleted SuccessFully");	
				RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
				return;
			}
			else {
				request.getSession().setAttribute("error", "Something Wrong in Deleting");
				RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
				return;
			}
			
		}
		catch(Exception e) {
			System.out.println("execption  : "+e);
			request.getSession().setAttribute("error", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
