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
	String scriptletTag="Srciptlet Tag";
	show();
%>
<%!
	public static final String declarationTag="This is Declration tag";
	public void show(){
	System.out.println("show method from declration tag");
	}
	
%>
<%=declarationTag %>

</body>
</html>