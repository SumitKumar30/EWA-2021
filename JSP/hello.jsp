<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@
	include file="index.jsp"
%>
<meta charset="ISO-8859-1">
<title>Hello JSP</title>
</head>
<body>
	<h2> Welcome to the world of JSP! </h2>
	<p> This is the demo page for JSP. Embedding the java code inside html now!! </p>
	<!-- Scriptlet -->
	<%
		out.println("Hello Java");
		Date date = new Date();
		out.println("Todays Date is: "+date);
			System.out.println("This is for debugging...");
	%>
</body>
<footer>
	<%@ 
		include file="Visitor.jsp"
	%>
</footer>
</html>