<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- necessary for jstl, do remember to add jar files in web inf/lib --> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="number" begin="1" end="5">
<c:out value="${number}"></c:out>
</c:forEach>

<c:import url="http://google.com"></c:import>
<c:redirect> url="index.html"</c:redirect> <!-- samee as sendredirect -->
<c:catch> 
<%
int x=0/0; //catch block to handle excption automatically
%>
</c:catch>
</body>
</html>