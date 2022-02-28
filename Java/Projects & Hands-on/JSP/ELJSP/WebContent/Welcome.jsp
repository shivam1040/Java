<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
aa ${param.name} <!-- EL(implicit expression language) method to print elements in DOM -->
${sessionScope.a} <!-- getting data in session from login jsp -->

<%
String name=request.getParameter("name");
%>
</body>
</html>