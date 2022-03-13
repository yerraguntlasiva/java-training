<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	
	System.out.println("forward1.jsp is executed");
	application.setAttribute("name", "context attribute232");
	session.setAttribute("name", "session name23");
	pageContext.setAttribute("name", "page context name23");//only for this page
%>
<jsp:forward page="farward2.jsp">
<jsp:param value="sharukh" name="name" />
</jsp:forward>
</body>
</html>