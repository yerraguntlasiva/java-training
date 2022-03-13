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
	//String userName=request.getParameter("userName");
	Cookie ck[]=request.getCookies();
	for(Cookie s:ck){
		System.out.println("cookeic "+s.getName() + " value  : "+s.getValue()); 
	}
	
%>
<h1>Welcome  in jsp <%=ck[0].getValue()%></h1>
</body>
</html>