<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome To Page1</h1>
<%!
//page scope
String scopeDate="this page Scope Date";

%>
<%=scopeDate %>
<%
	request.setAttribute("name", "request scope name23");//you can access this page only 
	//RequestDispatcher rd=request.getRequestDispatcher("/JSP-Demo4-Scope/page2.jsp");
	//rd.forward(request, response);
	session.setAttribute("name", "session name23");
	application.setAttribute("name", "context name2323");
	
	System.out.println("request scope " +request.getAttribute("name"));

%>
<br><br>
<a href="/JSP-Demo4-Scope/page2.jsp?name=request name from link" >GO To Page2</a>

<form action="/JSP-Demo4-Scope/page2.jsp?" method="post">
<input type="text" name="name">
<input type="submit" value="submit">
</form>
</body>
</html>