<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome To Page2</h1>
<%

System.out.println("request scope getParameter" +request.getParameter("name"));
System.out.println("session scope getAttribute" +session.getAttribute("name"));
System.out.println("application scope getAttribute" +application.getAttribute("name"));

	//System.out.println("request scope getAttribute : " +request.getAttribute("name"));//wont wor in next page
%>

</body>
</html>