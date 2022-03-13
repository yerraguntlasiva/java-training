<%@page import="com.org.beans.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to Update Profile Page</h2>
	<%
		Object objEmp = session.getAttribute("emp");
		Employee emp = null;

		if (objEmp != null) {
			emp = (Employee) objEmp;
		}

		if (emp == null) {
			session.setAttribute("error", "Please login Before Continue");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}
	%>
	<br>
	<form action="/update?current_user=true" method="post">
		<label for="fname"> ID:</label><br> <input type="number"
			name="id" value="<%=emp.getId()%>" disabled><br> <input
			type="number" name="id" value="<%=emp.getId()%>"
			style="display: none"><br> <label for="fname">Name:</label>
		<br> <input type="text" name="name"
			value="<%=emp.getName()%>"> <br> <label
			for="fname">Email:</label> <br> <input type="text" name="email"
			value="<%=emp.getEmail()%>"> <br> <label
			for="fname">Password:</label> <br> <input type="text"
			name="password" value="<%=emp.getPassword()%>"> <br>
		<label for="fname">Salary:</label> <br> <input type="text"
			name="salary" value="<%=emp.getSalary()%>"> <br>

		<input type="text" value="true" name="current_user" style="display: none"  />
		<br> <input type="submit" value="Update Details">

	</form>

</body>
</html>