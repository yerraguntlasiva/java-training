<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
System.out.println("errroPage exception : "+exception.getMessage());
%>
<h1>this is a error page</h1>
<h2><%=exception.getMessage() %></h2>
</body>
</html>