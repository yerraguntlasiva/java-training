<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.org.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Action Tag</h1>
	<jsp:useBean id="student1" class="com.org.Student" scope="session">
		<jsp:setProperty  property="id" name="student1" value="101"/>
		<jsp:setProperty property="name" name="student1" value="srk"/>
	</jsp:useBean>
	<br>
	<h2><%=student1 %></h2>
	<h2>id : <jsp:getProperty property="id"  name="student1" /></h2>
	<h2>name : <jsp:getProperty property="name" name="student1" /></h2>
	<%
	System.out.println(application.getAttribute("name"));
	System.out.println(session.getAttribute("name"));
	pageContext.removeAttribute("name");//this will remove the attribute from all scope
	System.out.println(session.getAttribute("name"));
	System.out.println(application.getAttribute("name"));
%>
</body>
</html>