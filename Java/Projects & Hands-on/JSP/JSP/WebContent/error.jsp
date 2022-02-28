<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
if(exception instanceof ArithmeticException)
out.println(exception); //exception can only be passed if iserropage attri of page directove is set to true
%>
</body>
</html>