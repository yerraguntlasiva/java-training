<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String username=(String)session.getAttribute("username");
System.out.println("session in home : "+username);

if(username==null){
	request.getRequestDispatcher("index.jsp").forward(request, response);
	
}
//session.invalidate();

%>
<H2>Welcome to Home  <%=username %></H2>
</body>
</html>