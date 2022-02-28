<%@taglib uri="/WEB-INF/bodyTag.tld" prefix="bod" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<bod:body><h1>ee</h1></bod:body> <!-- bodyTagSupport class is used for passing html tags or content insude custom tags -->
<%
out.println(request.getAttribute("bod")); //here tag stored in custom tag gets printed in dom in htm format after getting passed to  and executed by bodyTag
%>
</body>
</html>