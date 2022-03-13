<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.org.Demo"
     errorPage="errorPage.jsp" 
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Directive Demo</h1>

<%
         // Throw an exception to invoke the error page
         int x = 1;
			System.out.println("index.jsp before exception");
         if (x == 1) {
        	//int a=1/0;
            //throw new RuntimeException("Error condition!!!");
         }
      %>
      <%
      	Demo demo=new Demo();
      System.out.println("list : "+demo.list);	
      	for(String s:demo.list){
      		System.out.println("list : "+s);	
      		%>
      		<h2><%=s %></h2>
      		<%
          
      	} 
      %>

<%@ include file="include.jsp" %>
</body>
</html>