<%@page import="java.util.*" %> <%--imports the given class, directive tag --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
bb
<%


int x=11;
pageContext.setAttribute("name", x, PageContext.APPLICATION);//setting data at global level, another way
String name=request.getParameter("requestJSP"); //this calls implicit object and gets the value of requested parameter
out.print(this.x); //out is implicit obj of printwriter as used in service methods
%>

<%="hello"%>

<%!  //declarative tag
int x=10;
int a=11;
int square(int y){
	
	return y*y;
}
%>

<%=square(10)%> <%--expression tag --%>

<jsp:useBean id="obj" class="beans" scope="application"></jsp:useBean> <!-- creates object of beans class having varname obj, beans are classes for storing data, scope defines the availabality of obj by default scope is throughout page -->
<jsp:getProperty property="a" name="obj"/> <!-- gets attribute a from class having object id obj, btw usebean checks if the object with given id exists or not then only creates object, to use getproperty for an object ensure to use jsp usebean and getproperty tag inconjunction follow the same when using in other jsp too when dispatcher forwareded or included -->
<jsp:setProperty property="*" name="obj"/> <!-- this will take the object created above and store the various recieved value of parameters into respective variables in variables of class having object obj, for instance phone parameter will get stored in phone variable name etc. -->
<jsp:forward page="index.html"></jsp:forward> <!-- same as forward of req dispatcher, use this tag standalone not nested with any other tag, like if there is if condition to execute this forward tag then use forward action tag right after closing the scriptlet containing if condition -->
<jsp:getProperty property="a" name="obj"/> <!-- prints the value of var a on screen -->

<jsp:setProperty property="a" name="obj" value="<%=a%>"/> <!-- value of attribute a of class having object obj is set to a global variable(declarative tag)/local variable(scriptlet tag) value -->
<%	application.setAttribute("objn", obj); //setting an object in objn at application level, for session level use session.setAttri etc.
%>
<jsp:forward page="a.jsp"></jsp:forward> <!-- this forward same as dispatcher forward and this will take take above attribute to a.jsp -->
<input type="text" name="ma" value=${param.ma}/> <!-- another use of el $ tag -->

</body>
</html>