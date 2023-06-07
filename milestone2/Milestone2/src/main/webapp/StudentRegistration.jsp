<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>

<H2>Global Logic School Management Application</H2>
<h1>Provide your details here</h1>
<form action="user?action=register" method="post">
	<label>Username</label>
	<input type="text" name="username"><br><br>
	<label>Password</label>
	<input type="password" name="password"><br><br>
	<label>Class Name</label>
	<input type="text" name="className"><br><br>
	<label>Section</label>
	<input type="text" name="section"><br><br>
	<label>Student Roll Number</label>
	<input type="text" name="studentRollNo"><br><br>
	
	<input type="radio" name="role" value=0>
	<label for="student">Student</label>
	<br><br>
	<br><button>Register</button>
	
</form>
</body>
</html>