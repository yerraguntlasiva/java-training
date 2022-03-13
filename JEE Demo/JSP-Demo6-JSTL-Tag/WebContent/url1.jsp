<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>this url jsp fiel</h2>
<%
	String name=request.getParameter("name").toString();
%>
parameter : <c:out value="<%=name %>"></c:out>

</body>
</html>