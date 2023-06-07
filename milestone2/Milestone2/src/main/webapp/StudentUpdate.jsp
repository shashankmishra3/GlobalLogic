<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.gl.to.Student, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update of Student</title>
</head>
<body>

<center>
<h1>Update</h1>
<form action="studentcontrol?action=updateStudentVal" method="post">
	<label>Username</label>
	<input type="text" name="username" value="<%= request.getParameter("username") %>" readonly="readonly" ><br><br>
	<label>Password</label>
	<input type="password" name="password"><br><br>
	<label>Class Name</label>
	<input type="text" name="className"><br><br>
	<label>Section</label>
	<input type="text" name="section"><br><br>
	<label>Student Roll Number</label>
	<input type="text" name="studentRollNo"><br><br>
	<label>Status</label>
	<input type="text" name="status"><br><br>
	<input type="radio" name="role" value=0>
	<label for="student">Student</label>
	<br><br>
	<br><button>Update</button>
	
</form>
</center>
</body>
</html>