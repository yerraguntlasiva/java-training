<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><c:out value="This is s:out"></c:out></h3>

<c:import var="data" url="http://localhost:8084/JSP-Demo6-JSTL-Tag/include.jsp"/>  
<c:out value="${data}"/>  

<!-- it will print all data -->

<c:set var="balance" scope="request" value="${5000*50 }"></c:set>
<c:if test="${balance>40000 }">
	<h3>actual balance is <%=request.getAttribute("balance") %></h3>
	<h3>actual balance is <c:out value="${balance}"></c:out></h3>
</c:if>

<c:remove var="balance"/>  
<p>After Remove Value is: <c:out value="${balance}"/></p> 

 
<c:catch var ="catchtheException">  
   <% int x = 2/0;%>  
</c:catch>
<c:out value="${ catchtheException.getMessage()}"></c:out>

<c:set var="income" scope="session" value="${4000*4}"/>  
<p>Your income is : <c:out value="${income}"/></p>  
<c:choose>  
    <c:when test="${income <= 1000}">  
       Income is not good.  
    </c:when>  
    <c:when test="${income > 10000}">  
        Income is very good.  
    </c:when>  
    <c:otherwise>  
       Income is undetermined...  
    </c:otherwise>  
</c:choose>  
</body>
</html>