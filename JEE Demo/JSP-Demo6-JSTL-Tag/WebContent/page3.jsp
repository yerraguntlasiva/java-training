<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var="url" value="0" scope="request"/>  
  <c:if test="${url<1}">  
     <c:redirect url="http://localhost:8084/JSP-Demo6-JSTL-Tag/page2.jsp"/>  
  </c:if>  
  <c:if test="${url>1}">  
     <c:redirect url="http://localhost:8084/JSP-Demo6-JSTL-Tag/page1.jsp"/>  
  </c:if> 
  <c:url value="/RegisterDao.jsp"/> 
</body>
</html>