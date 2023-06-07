<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration</title>
</head>
<body>



<H2>Global Logic School Management Application</H2>
<h1>Provide your details here</h1>
<form action="user?action=register" method="post">
	<label>Username</label>
	<input type="text" name="username"><br><br>
	<label>Password</label>
	<input type="password" name="password"><br><br>
	<label>Admin ID</label>
	<input type="text" name="adminID"><br><br>
	
	<input type="radio" name="role" value=2>
	<label for="admin">Admin</label>
	<br><br>

	<br><button>Register</button>
	
</form>
</body>
</html>