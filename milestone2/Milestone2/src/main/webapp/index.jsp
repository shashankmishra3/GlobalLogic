<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String registerSuccessMsg = ( String ) request.getAttribute("register_success");
	String errorMessage = ( String ) request.getAttribute("errorMessage");
	String logoutMsg = ( String ) request.getAttribute("logoutMsg");
%>

	<H2>Global Logic School Management Application</H2>
	
	<%
	if(registerSuccessMsg != null) {
	%>
	<%= registerSuccessMsg %>
	<%} %>
	<%
	if(logoutMsg != null) {
	%>
	<%= logoutMsg %>
	<%} %>
	<%
	if(errorMessage != null) {
	%>
	<%= errorMessage %>
	<%} %>
	<form action="user?action=login" method="post">
	<label>UserName</label> &nbsp; <input type="text" name="username"></input><br><br>
	<label>Password</label> &nbsp; <input type="password" name="password"></input><br><br>
	
	<input type="radio" name="role" value=0>
	<label for="student">Student</label>
	<input type="radio" name="role" value=1>
	<label for="teacher">Teacher</label>
	<input type="radio" name="role" value=2>
	<label for="admin">admin</label>
	
	<br><br>
	
	<button type ="Submit">Login</button>
	</form>
	<br>
	<a href="StudentRegistration.jsp"> new user ?? register as a Student</a> &nbsp;
	<a href="TeacherRegistration.jsp"> Teacher</a> &nbsp;
	<a href="AdminRegistration.jsp"> Admin</a>
	
</body>
</html>	