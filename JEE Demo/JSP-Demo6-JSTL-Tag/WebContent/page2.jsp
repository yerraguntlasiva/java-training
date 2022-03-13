<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="j" begin="1" end="3">  
   Item <c:out value="${j}"/><p>  
</c:forEach> 
<h3>----------------------1 for loop---------------------</h3>
<%!
	String sArr[]=new String[]{"a","b","c","d"};
	List<String> list=new ArrayList();
	
%>
<%
list.add("sharukh");
list.add("ramesh");
list.add("sachin");
list.add("sharukh");
%>
<c:set var="list" value="<%=list %>"></c:set>
<c:forEach items="${list }" var="jl" >  
   <c:out value="${jl}" /><p> <br> 
</c:forEach> 
<h3>----------------------2 for loop---------------------</h3>
<c:forTokens items="Rahul-Nakul-Rajesh" delims="-" var="name">  
   <c:out value="${name}"/><p>  
</c:forTokens>

<h3>----------------------c:url---------------------</h3>
<c:url value="/url1.jsp" var="completeURL">  
 <c:param name="name" value="srk"/>  
 <c:param name="email" value="srk@gmail.com"/>  
</c:url>  
${completeURL} 
<br><br>
<a href="${ completeURL}">url1 page</a> 
<h1>end</h1>
</body>
</html>