<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H1>FORWARD2 JSP</H1>
<h2><%=request.getParameter("name") %></h2>
<%
	System.out.println(application.getAttribute("name"));
	System.out.println(session.getAttribute("name"));
	System.out.println(pageContext.getAttribute("name"));
%>
</body>
</html>